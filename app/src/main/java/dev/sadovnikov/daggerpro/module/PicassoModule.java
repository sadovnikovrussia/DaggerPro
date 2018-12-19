package dev.sadovnikov.daggerpro.module;

import android.content.Context;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;


import dagger.Module;
import dagger.Provides;
import dev.sadovnikov.daggerpro.interfaces.ApplicationContext;
import dev.sadovnikov.daggerpro.interfaces.RandomUserApplicationScope;
import okhttp3.OkHttpClient;

@Module(includes = {OkHttpClientModule.class, ContextModule.class})
public class PicassoModule {
    private static final String TAG = "PicassoModule";

    @RandomUserApplicationScope
    @Provides
    Picasso picasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloader) {
        Picasso build = new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
        Log.d(TAG, "picasso: " + build.toString());
        return build;
    }

    @Provides
    OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader(okHttpClient);
        Log.d(TAG, "okHttp3Downloader: " + okHttp3Downloader.toString());
        return okHttp3Downloader;
    }
}
