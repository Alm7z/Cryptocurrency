package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.database.DBLoader;
import tony.itis.kpfu.ru.cryptocurrency.database.InterfaceForDB;
import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;
import tony.itis.kpfu.ru.cryptocurrency.database.DatabaseManager;
import tony.itis.kpfu.ru.cryptocurrency.network.Downloader;
import tony.itis.kpfu.ru.cryptocurrency.network.InterfaceForNetwork;

/**
 * Created by al on 25.12.17.
 */

public class MainPresenter implements InterfaceForNetwork, InterfaceForDB {

    private MainView mainView;

    private Activity activity;

    private Downloader downloader;

    private DBLoader dbLoader;

    private List<OneData> datas;

    //DatabaseManager databaseManager;

    public MainPresenter(MainView mainView, Activity activity) {
        this.mainView = mainView;
        this.activity = activity;

        this.downloader = new Downloader(this, activity);

        //databaseManager=new DatabaseManager(activity);

        dbLoader = new DBLoader(this, activity);
    }

    public void load() {
        downloader.load();
    }


    @Override
    public void onNetworkLoadingSucces(List<OneData> list) {
        datas = list;

        dbLoader.replace(list);

        mainView.onLoadingFromInternet(list);
    }

    @Override
    public void onNetworkLoadingError() {
        dbLoader.load();
    }

    @Override
    public void onDBLoadingSucces(List<OneData> list) {
        if (list != null && list.size() > 0) {
            mainView.onLoadingFromDatabase(list);
        }
        else{
            mainView.onEmptyDatabase();
        }
    }

    @Override
    public void onDBLoadingError() {
        //mainView.onLoadingError();
        Log.d("Alm", "onDBLoadingError");
    }
}
