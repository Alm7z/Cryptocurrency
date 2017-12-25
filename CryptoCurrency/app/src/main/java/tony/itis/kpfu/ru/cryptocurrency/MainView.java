package tony.itis.kpfu.ru.cryptocurrency;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by al on 25.12.17.
 */

public interface MainView {

    void onLoadingFromInternet(List<OneData> list);

    void onLoadingFromDatabase(List<OneData> list);

    void onEmptyDatabase();

    //void onLoadingError();

}
