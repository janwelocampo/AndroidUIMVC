package dstudio.com.danapotplant.ui.profile.view;

import dstudio.com.danapotplant.model.Profile;

/**
 * Created by janwelcris on 8/14/2017.
 */

public interface ProfileView {

    void showLoading();

    void hideLoading();

    void showErrorMessage(String errorMessage);

    void showProfileData(Profile profile);

}
