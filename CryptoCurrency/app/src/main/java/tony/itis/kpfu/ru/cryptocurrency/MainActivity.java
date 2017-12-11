package tony.itis.kpfu.ru.cryptocurrency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.Entity.OneData;
import tony.itis.kpfu.ru.cryptocurrency.network.Downloader;
import tony.itis.kpfu.ru.cryptocurrency.network.InterfaceForNetwork;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Downloader d=new Downloader(new InterfaceForNetwork() {
            @Override
            public void onLoadingSucces(List<OneData> list) {
                for (OneData d :
                        list) {
                    Log.d("Alm","ok"+d.getName());
                }
            }

            @Override
            public void onLoadingError() {
                Log.d("Alm","onLoadingError");
            }
        }
        ,this);
        d.load();

    }
}
