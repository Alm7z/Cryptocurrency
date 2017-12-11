package tony.itis.kpfu.ru.cryptocurrency.network;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.Entity.OneData;

/**
 * Created by al on 11.12.17.
 */

public interface InterfaceForNetwork {
    void onLoadingSucces(List<OneData> list);
    void onLoadingError();

}
