package dev.sadovnikov.daggerpro.module;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dev.sadovnikov.daggerpro.interfaces.RandomUserApplicationScope;

@Module
public class ActivityModule {
    Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    //@Named("activity_context")
    //@RandomUserApplicationScope
    @Provides
    Context context(){
        return context;
    }

}
