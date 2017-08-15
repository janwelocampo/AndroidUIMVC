package dstudio.com.danapotplant.screenview.profile;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;

import dstudio.com.danapotplant.api.APIInterface;
import dstudio.com.danapotplant.api.connectivity.NoNetworkException;
import dstudio.com.danapotplant.model.Profile;
import dstudio.com.danapotplant.dagger.applications.ProfileApplication;
import dstudio.com.danapotplant.util.DanaPotPlantUtils;
import dstudio.com.danapotplant.util.SharedPreferencesUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by janwelcris on 8/14/2017.
 */

public class ProfilePresenterImpl implements ProfilePresenter, DanaPotPlantUtils {

    private ProfileView view;

    @Inject
    APIInterface apiInterface;

    @Inject
    SharedPreferencesUtils sharedPreferencesUtils;

    private Gson mGson;

    public ProfilePresenterImpl(Context context) {
        ((ProfileApplication) context).getAppComponent().inject(this);
        mGson = new Gson();
    }
    @Override
    public void setView(ProfileView view) {
        this.view = view;
    }

    @Override
    public void getProfileData() {
        view.showLoading();

        apiInterface.doGetProfileData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Profile>() {
                    @Override
                    public void onCompleted() {
                        view.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideLoading();
                        if (e instanceof NoNetworkException) {
                            // handle 'no network'
                            view.showErrorMessage("No internet connection");
                        }
                        else
                        {
                            view.showErrorMessage(e.getLocalizedMessage());
                        }

                    }

                    @Override
                    public void onNext(Profile profile) {
                        sharedPreferencesUtils.setData(SKILLS, mGson.toJson(profile.getSkills()));
                        sharedPreferencesUtils.setData(EXAMS, mGson.toJson(profile.getExams()));
                        view.showProfileData(profile);
                    }
                });
    }
}
