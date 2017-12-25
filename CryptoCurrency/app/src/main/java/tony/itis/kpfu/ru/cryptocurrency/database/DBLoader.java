package tony.itis.kpfu.ru.cryptocurrency.database;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import me.tatarka.rxloader.RxLoader;
import me.tatarka.rxloader.RxLoaderManager;
import me.tatarka.rxloader.RxLoaderObserver;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by al on 25.12.17.
 */

public class DBLoader {

    public static final String LOADER_DB_SELECT ="loader_db_select";
    public static final String LOADER_DB_REPLACE ="loader_db_replace";


    private InterfaceForDB interfaceForDB;
    //private Activity activity;
    private RxLoaderManager loaderManager;
    private DatabaseManager databaseManager;

    private RxLoader<List<OneData>> loaderSelect;

    private RxLoader<Long> loaderReplace;

    public DBLoader(InterfaceForDB interfaceForDB, Activity activity) {
        this.interfaceForDB = interfaceForDB;
        //this.activity = activity;

        this.loaderManager = RxLoaderManager.get(activity);
        this.databaseManager=new DatabaseManager(activity);
    }

    public void load(){

        loaderSelect = loaderManager.create(LOADER_DB_SELECT,
                databaseManager.getSelectQuery()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                new RxLoaderObserver<List<OneData>>() {
                    @Override
                    public void onNext(List<OneData> value) {
                        Log.d("Alm", "select onNext: "+value.size());
//                        for (OneData d :
//                                value) {
//                            Log.d("Alm", d.getName());
//                        }

                        interfaceForDB.onDBLoadingSucces(value);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Alm","select onError");

                        interfaceForDB.onDBLoadingError();

                        loaderSelect.clear();
                    }

                    @Override
                    public void onCompleted() {
                        Log.d("Alm","select onCompleted");

                        loaderSelect.clear();
                    }
                }).restart();

    }

    public void replace(List<OneData> datas) {

//        loaderManager.create(Observable.just(1), new RxLoaderObserver<Integer>() {
//            @Override
//            public void onNext(Integer value) {
//                Log.d("Alm","ok!!! "+value);
//            }
//        }).restart();

        loaderReplace = loaderManager.create(LOADER_DB_REPLACE,
                Observable
                        .concat(databaseManager.getTableClearQuery(),
                                databaseManager.getTableInsertQuery(datas))
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()),
                new RxLoaderObserver<Long>() {
                    @Override
                    public void onNext(Long value) {
                        //Log.d("Alm","Replace Next");
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("Alm","Replace Error");

                        loaderReplace.clear();
                    }

                    @Override
                    public void onCompleted() {

                        Log.d("Alm","Replace Complete");

                        loaderReplace.clear();
                    }
                }).restart();

    }
}
