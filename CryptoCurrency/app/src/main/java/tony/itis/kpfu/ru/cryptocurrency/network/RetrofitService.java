package tony.itis.kpfu.ru.cryptocurrency.network;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by al on 11.12.17.
 */

public interface RetrofitService {

    @GET("/v1/ticker/")
    Observable<List<OneData>> getData();

}
