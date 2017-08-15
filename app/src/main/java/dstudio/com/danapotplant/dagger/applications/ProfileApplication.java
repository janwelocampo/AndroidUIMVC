package dstudio.com.danapotplant.dagger.applications;

import android.app.Application;

import dstudio.com.danapotplant.dagger.AppComponent;
import dstudio.com.danapotplant.dagger.AppModule;
import dstudio.com.danapotplant.dagger.DaggerAppComponent;

/**
 * Created by janwelcris on 8/14/2017.
 */

public class ProfileApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(ProfileApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}