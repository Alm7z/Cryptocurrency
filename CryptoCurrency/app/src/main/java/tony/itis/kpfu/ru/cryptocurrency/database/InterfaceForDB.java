package tony.itis.kpfu.ru.cryptocurrency.database;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by al on 25.12.17.
 */

public interface InterfaceForDB {

    void onDBLoadingSucces(List<OneData> list);

    void onDBLoadingError();

}
