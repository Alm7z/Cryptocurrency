package tony.itis.kpfu.ru.cryptocurrency;

import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_view)
    public Toolbar toolbar;

    @BindView(R.id.price)
    public TextView price;

    @BindView(R.id.calculator)
    public ImageButton calculator;

    @BindView(R.id.plus)
    public ImageButton plus;



    @OnClick(R.id.calculator)
    void onCalcClick() {
        startActivity(new Intent(MainActivity.this, CalcActivity.class));
    }

    @OnClick(R.id.plus)
    void onPlusClick() {
        new MaterialDialog.Builder(this)
                .title("Adding new currency")
                .customView(R.layout.dialog_add_new, true)
                .positiveText("OK")
                .negativeText("Cancel")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        onBackPressed();
                    }
                })
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);

        if (getFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, makeFragment())
                    .commit();
        }

        ButterKnife.bind(this);
    }

    public static Intent makeIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    private Fragment makeFragment() {
        return MainFragment.newInstance();
    }
}