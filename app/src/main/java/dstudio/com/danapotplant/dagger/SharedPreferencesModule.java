package dstudio.com.danapotplant.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janwelcris on 8/15/2017.
 */
@Module
public class SharedPreferencesModule  {

    @Provides
    @Singleton
    @Inject
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }
}