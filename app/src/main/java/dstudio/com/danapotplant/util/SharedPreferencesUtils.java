package dstudio.com.danapotplant.util;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by janwelcris on 8/15/2017.
 */

public class SharedPreferencesUtils {
    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPreferencesUtils(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void setData(String key, String data) {
        mSharedPreferences.edit().putString(key,data).apply();
    }

    public String getData(String key) {
        return mSharedPreferences.getString(key,null);
    }
}