package dev.sadovnikov.daggerpro.MainActivityFeature;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import dev.sadovnikov.daggerpro.MainActivity;
import dev.sadovnikov.daggerpro.adapters.RandomUsersRvAdapter;

@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RandomUsersRvAdapter randomUsersRvAdapter(Picasso picasso) {
        RandomUsersRvAdapter randomUsersRvAdapter = new RandomUsersRvAdapter(mainActivity, picasso);
        return randomUsersRvAdapter;
    }
}
