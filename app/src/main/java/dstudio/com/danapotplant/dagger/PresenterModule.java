package dstudio.com.danapotplant.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dstudio.com.danapotplant.ui.profile.fragment.activitypresenter.ProfilePresenter;
import dstudio.com.danapotplant.ui.profile.fragment.activitypresenter.ProfilePresenterImpl;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter.ProfileFragmentPresenter;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter.ProfileFragmentPresenterImpl;

/**
 * Created by janwelcris on 8/14/2017.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ProfilePresenter provideProfilePresenter(Context context) {
        return new ProfilePresenterImpl(context);
    }

    @Provides
    @Singleton
    ProfileFragmentPresenter provideProfileFragmentPresenter(Context context) {
        return new ProfileFragmentPresenterImpl(context);
    }


}
