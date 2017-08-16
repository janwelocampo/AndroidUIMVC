package dstudio.com.danapotplant.ui.profile.fragment.activitypresenter;

import android.content.Context;

import javax.inject.Inject;

import dstudio.com.danapotplant.api.APIInterface;
import dstudio.com.danapotplant.api.connectivity.NoNetworkException;
import dstudio.com.danapotplant.dagger.applications.App;
import dstudio.com.danapotplant.model.Profile;
import dstudio.com.danapotplant.ui.profile.fragment.activityview.ProfileView;
import dstudio.com.danapotplant.util.DanaPotPlantUtils;
import dstudio.com.danapotplant.util.ObjectManager;
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
    ObjectManager objectManager;


    public ProfilePresenterImpl(Context context) {
        ((App) context).getAppComponent(context).inject(this);

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
                        objectManager.save(profile.getExams(), EXAMS);
                        objectManager.save(profile.getSkills(), SKILLS);
                        view.showProfileData(profile);
                    }
                });
    }
}
