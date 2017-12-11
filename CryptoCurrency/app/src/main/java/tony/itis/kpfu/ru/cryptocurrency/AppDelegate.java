package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tony.itis.kpfu.ru.cryptocurrency.network.RetrofitService;

/**
 * Created by al on 11.12.17.
 */

public class AppDelegate extends Application{

    public static final String BASE_URL="https://api.coinmarketcap.com";

    private RetrofitService retrofitService;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitService=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient())
                .build()
                .create(RetrofitService.class);
    }

    public RetrofitService getRetrofitService() {
        return retrofitService;
    }
}
