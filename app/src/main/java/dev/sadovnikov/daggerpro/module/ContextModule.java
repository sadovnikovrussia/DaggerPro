package dev.sadovnikov.daggerpro.module;

import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import dev.sadovnikov.daggerpro.interfaces.ApplicationContext;
import dev.sadovnikov.daggerpro.interfaces.RandomUserApplicationScope;

@Module
public class ContextModule {
    private static final String TAG = "ContextModule";

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        Context context = this.context.getApplicationContext();
        Log.d(TAG, "context: " + context);
        return context;
    }
}
