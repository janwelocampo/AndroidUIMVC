package dstudio.com.danapotplant.ui.profile.fragment.activitypresenter;

import dstudio.com.danapotplant.ui.profile.fragment.activityview.ProfileView;

/**
 * Created by janwelcris on 8/14/2017.
 */

public interface ProfilePresenter {

    void setView(ProfileView view);

    void getProfileData();
}
