package dstudio.com.danapotplant.api;

import dstudio.com.danapotplant.model.Profile;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by janwelcris on 8/14/2017.
 */

public interface APIInterface {

    @GET("/janwelocampo/AndroidTutorial/master/profile.json")
    Observable<Profile> doGetProfileData();
}
