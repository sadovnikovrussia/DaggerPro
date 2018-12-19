package dev.sadovnikov.daggerpro.module;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.sadovnikov.daggerpro.interfaces.RandomUserApplicationScope;
import dev.sadovnikov.daggerpro.interfaces.RandomUsersApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Он же ApiFactory
@Module(includes = OkHttpClientModule.class)
public class RandomUsersModule {
    private static final String TAG = "RandomUsersModule";

    //@Singleton
    //@RandomUserApplicationScope
    @Provides
    RandomUsersApi randomUsersApi(Retrofit retrofit) {
        RandomUsersApi randomUsersApi = retrofit.create(RandomUsersApi.class);
        Log.d(TAG, "randomUsersApi: " + randomUsersApi);
        return randomUsersApi;
    }

    @RandomUserApplicationScope
    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        Retrofit build = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(gsonConverterFactory)
                .build();
        Log.d(TAG, "retrofit: " + build.toString());
        return build;
    }

    //@RandomUserApplicationScope
    @Provides
    GsonConverterFactory gsonConverterFactory() {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        Log.d(TAG, "gsonConverterFactory: " + gsonConverterFactory.toString());
        return gsonConverterFactory;
    }
}
