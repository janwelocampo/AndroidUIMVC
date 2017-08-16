package dstudio.com.danapotplant.ui.profile.fragment.profilefragment.presenter;


import dstudio.com.danapotplant.ui.profile.fragment.profilefragment.view.ProfileFragmentView;

/**
 * Created by janwelcris on 8/15/2017.
 */

public interface ProfileFragmentPresenter {

    void setView(ProfileFragmentView view);

    void getProfileTabData();
}
