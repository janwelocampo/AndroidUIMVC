package dstudio.com.danapotplant.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dstudio.com.danapotplant.screenview.profile.ProfileActivity;
import dstudio.com.danapotplant.screenview.profile.ProfilePresenterImpl;

/**
 * Created by janwelcris on 8/14/2017.
 */
@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    void inject(ProfileActivity target);

    void inject(ProfilePresenterImpl target);

}