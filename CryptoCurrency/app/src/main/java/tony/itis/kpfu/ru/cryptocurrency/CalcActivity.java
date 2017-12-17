package tony.itis.kpfu.ru.cryptocurrency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bulat Murtazin on 17.12.2017.
 * KPFU ITIS 11-601
 */

public class CalcActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_view)
    private Toolbar toolbar;

    @BindView(R.id.back)
    private ImageView back;

    @BindView(R.id.price)
    private TextView price;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }
}
