package tony.itis.kpfu.ru.cryptocurrency.network;

import java.util.List;

import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by al on 11.12.17.
 */

public interface InterfaceForNetwork {

    void onNetworkLoadingSucces(List<OneData> list);

    void onNetworkLoadingError();

}
