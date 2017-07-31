package chhatrasal.app.com.redcarpetassignment.webService;

import chhatrasal.app.com.redcarpetassignment.javaClass.RxJavaResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by chhatrasal on 31/7/17.
 */

public interface APIService {

    @GET("tutorial/jsonparsetutorial.txt")
    Observable<RxJavaResponse> getPopulationData();
}
