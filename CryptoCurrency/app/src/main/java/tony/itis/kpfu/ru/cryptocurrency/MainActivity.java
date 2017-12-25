package tony.itis.kpfu.ru.cryptocurrency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

public class MainActivity extends AppCompatActivity {

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
}
