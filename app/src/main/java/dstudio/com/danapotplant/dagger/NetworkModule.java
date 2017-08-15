package dstudio.com.danapotplant.dagger;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dstudio.com.danapotplant.api.APIInterface;
import dstudio.com.danapotplant.api.connectivity.NetworkInterceptor;
import dstudio.com.danapotplant.util.DanaPotPlantUtils;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by janwelcris on 8/14/2017.
 */

@Module
public class NetworkModule implements DanaPotPlantUtils {

    private static final String NAME_BASE_URL = BASE_URL;

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideCallAdapterFactory(){return RxJavaCallAdapterFactory.create();}


    @Provides
    @Singleton
    Retrofit provideRetrofit(Context context, Converter.Factory converter, RxJavaCallAdapterFactory factory, @Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new NetworkInterceptor(context))
                        .build())
                .addConverterFactory(converter)
                .addCallAdapterFactory(factory)
                .build();
    }

    @Provides
    @Singleton
    APIInterface provideRetrofitAPI(Retrofit retrofit) {
        return retrofit.create(APIInterface.class);
    }

}
