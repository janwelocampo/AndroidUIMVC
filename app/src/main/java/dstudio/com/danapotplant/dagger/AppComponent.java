package dstudio.com.danapotplant.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dstudio.com.danapotplant.ui.profile.fragment.activityview.ProfileActivity;
import dstudio.com.danapotplant.ui.profile.fragment.activitypresenter.ProfilePresenterImpl;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view.ProfileFragment;
import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter.ProfileFragmentPresenterImpl;

/**
 * Created by janwelcris on 8/14/2017.
 */
@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class, ObjectManagerModule.class})
public interface AppComponent {
    void inject(ProfileActivity target);

    void inject(ProfilePresenterImpl target);

    void inject(ProfileFragmentPresenterImpl target);

    void inject(ProfileFragment target);
}