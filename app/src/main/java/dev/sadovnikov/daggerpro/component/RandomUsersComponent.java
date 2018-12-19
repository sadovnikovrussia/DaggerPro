package dev.sadovnikov.daggerpro.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import dev.sadovnikov.daggerpro.interfaces.RandomUserApplicationScope;
import dev.sadovnikov.daggerpro.interfaces.RandomUsersApi;
import dev.sadovnikov.daggerpro.module.PicassoModule;
import dev.sadovnikov.daggerpro.module.RandomUsersModule;

@RandomUserApplicationScope
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUsersComponent {

    RandomUsersApi getRandomUsersApi();

    Picasso getPicasso();
}
