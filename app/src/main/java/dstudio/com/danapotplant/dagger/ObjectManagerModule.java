package dstudio.com.danapotplant.dagger;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dstudio.com.danapotplant.util.ObjectManager;

/**
 * Created by janwelcris on 8/15/2017.
 */
@Module
public class ObjectManagerModule {

    @Singleton @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    @Singleton @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Singleton @Provides
    public ObjectManager provideObjectManager(SharedPreferences sharedPreferences, Gson gson){
        return new ObjectManager(sharedPreferences, gson);
    }
}