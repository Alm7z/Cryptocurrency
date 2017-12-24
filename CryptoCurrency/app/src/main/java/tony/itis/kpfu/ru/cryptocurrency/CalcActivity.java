package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bulat Murtazin on 17.12.2017.
 * KPFU ITIS 11-601
 */

public class CalcActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_view)
    public Toolbar toolbar;

    @BindView(R.id.back)
    public ImageView back;

    @BindView(R.id.price)
    public TextView price;

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        if (getFragmentManager().findFragmentById(R.id.calc_container) == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.calc_container, makeFragment())
                    .commit();
        }
    }

    private Fragment makeFragment() {
        return CalcFragment.newInstance();
    }
}
