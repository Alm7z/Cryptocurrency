package tony.itis.kpfu.ru.cryptocurrency;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;

import butterknife.BindView;

/**
 * Created by Bulat Murtazin on 24.12.2017.
 * KPFU ITIS 11-601
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.makeIntent(SplashActivity.this));
            }
        }, 3000);
    }
}
