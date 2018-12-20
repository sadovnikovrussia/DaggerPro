package dev.sadovnikov.daggerpro.MainActivityFeature;

import android.app.Activity;

import dagger.Component;
import dev.sadovnikov.daggerpro.adapters.RandomUsersRvAdapter;
import dev.sadovnikov.daggerpro.component.RandomUsersComponent;
import dev.sadovnikov.daggerpro.interfaces.RandomUsersApi;

@MainActivityScope
@Component(dependencies = RandomUsersComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void injectMainActivity(Activity activity);

}
