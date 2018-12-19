package dev.sadovnikov.daggerpro.module;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class OkHttpClientModule {
    private static final String TAG = "OkHttpClientModule";

    @Provides
    OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient build = new OkHttpClient()
                .newBuilder()
                //.cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Log.d(TAG, "okHttpClient: " + build.toString());
        return build;
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
                Log.i(TAG, "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        Log.d(TAG, "httpLoggingInterceptor: " + httpLoggingInterceptor.toString());
        return httpLoggingInterceptor;
    }
}
