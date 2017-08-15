package dstudio.com.danapotplant.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dstudio.com.danapotplant.screenview.profile.ProfilePresenter;
import dstudio.com.danapotplant.screenview.profile.ProfilePresenterImpl;

/**
 * Created by janwelcris on 8/14/2017.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ProfilePresenter provideFoodzPresenter(Context context) {
        return new ProfilePresenterImpl(context);
    }
}
