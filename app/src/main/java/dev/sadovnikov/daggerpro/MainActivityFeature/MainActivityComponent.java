package dev.sadovnikov.daggerpro.MainActivityFeature;

import dagger.Component;
import dev.sadovnikov.daggerpro.adapters.RandomUsersRvAdapter;
import dev.sadovnikov.daggerpro.component.RandomUsersComponent;
import dev.sadovnikov.daggerpro.interfaces.RandomUsersApi;

@MainActivityScope
@Component(dependencies = RandomUsersComponent.class)
public interface MainActivityComponent {
    RandomUsersRvAdapter getRandomUsersRvAdapter();
    RandomUsersApi getRandomUsersApi();
}
