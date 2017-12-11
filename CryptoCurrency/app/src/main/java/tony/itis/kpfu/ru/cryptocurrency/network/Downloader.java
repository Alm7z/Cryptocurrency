package tony.itis.kpfu.ru.cryptocurrency.network;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import me.tatarka.rxloader.RxLoader;
import me.tatarka.rxloader.RxLoaderManager;
import me.tatarka.rxloader.RxLoaderObserver;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tony.itis.kpfu.ru.cryptocurrency.AppDelegate;
import tony.itis.kpfu.ru.cryptocurrency.Entity.OneData;

/**
 * Created by al on 11.12.17.
 */

public class Downloader {
    private InterfaceForNetwork interfaceForNetwork;

    private RxLoaderManager loaderManager;

    private RetrofitService retrofitService;

    private static final String LOADER_NETWORK = "loader_network";

    //private Activity activity;

    private RxLoader<List<OneData>> loader;

    public Downloader(InterfaceForNetwork interfaceForNetwork, RxLoaderManager loaderManager, RetrofitService retrofitService) {
        this.interfaceForNetwork = interfaceForNetwork;
        this.loaderManager = loaderManager;
        this.retrofitService = retrofitService;
    }

    public Downloader(InterfaceForNetwork interfaceForNetwork, Activity activity) {
        this.interfaceForNetwork = interfaceForNetwork;
        //this.activity = activity;
        this.loaderManager = RxLoaderManager.get(activity);
        retrofitService = ((AppDelegate) activity.getApplication()).getRetrofitService();
    }

    public void load() {
        //RetrofitService retrofitService=((AppDelegate)getApplication()).getRetrofitService();

        //RxLoaderManager loaderManager=RxLoaderManager.get(this);

        loader = loaderManager.create(LOADER_NETWORK,
                retrofitService.getData()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                new RxLoaderObserver<List<OneData>>() {
                    @Override
                    public void onNext(List<OneData> value) {
                        Log.d("Alm", "onNext");
                        for (OneData d :
                                value) {
                            Log.d("Alm", d.getName());
                        }

                        interfaceForNetwork.onLoadingSucces(value);

                    }

                    @Override
                    public void onCompleted() {
                        Log.d("Alm", "onCompleted");
                        loader.clear();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Alm", "onError");

                        interfaceForNetwork.onLoadingError();

                        loader.clear();
                    }
                }).restart();
    }
}
