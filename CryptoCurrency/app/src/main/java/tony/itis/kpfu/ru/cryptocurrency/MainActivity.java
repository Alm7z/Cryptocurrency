package tony.itis.kpfu.ru.cryptocurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        //Example

        MainPresenter presenter = new MainPresenter(new MainView() {
            @Override
            public void onLoadingFromInternet(List<OneData> list) {
                Log.d("Alm", "from Internet: " + list.size());

            }

            @Override
            public void onLoadingFromDatabase(List<OneData> list) {

                Log.d("Alm", "from DB: " + list.size());

            }

            @Override
            public void onEmptyDatabase() {
                Log.d("Alm", "MainPresenter onEmptyDatabase");
            }
        }, this);

        presenter.load();

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