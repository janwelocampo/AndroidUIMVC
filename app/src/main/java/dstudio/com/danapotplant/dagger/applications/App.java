package dstudio.com.danapotplant.dagger.applications;

import android.app.Application;
import android.content.Context;

import dstudio.com.danapotplant.dagger.AppComponent;
import dstudio.com.danapotplant.dagger.AppModule;
import dstudio.com.danapotplant.dagger.DaggerAppComponent;

/**
 * Created by janwelcris on 8/14/2017.
 */

public class App extends Application {
    private AppComponent component;


    protected AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(Context context) {
        App app = (App) context.getApplicationContext();
        if (app.component == null) {
            app.component = app.createComponent();
        }
        return app.component;
    }
}