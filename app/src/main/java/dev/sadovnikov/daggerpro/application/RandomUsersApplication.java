package dev.sadovnikov.daggerpro.application;

import android.app.Activity;
import android.app.Application;

import dev.sadovnikov.daggerpro.component.DaggerRandomUsersComponent;
import dev.sadovnikov.daggerpro.component.RandomUsersComponent;
import dev.sadovnikov.daggerpro.module.ContextModule;
import timber.log.Timber;

public class RandomUsersApplication extends Application {
    RandomUsersComponent randomUsersApplicationComponent;

    public static RandomUsersApplication get(Activity activity) {
        return (RandomUsersApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        randomUsersApplicationComponent = DaggerRandomUsersComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public RandomUsersComponent getRandomUsersApplicationComponent(){
        return randomUsersApplicationComponent;
    }
}
