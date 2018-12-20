package dev.sadovnikov.daggerpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import dev.sadovnikov.daggerpro.MainActivityFeature.DaggerMainActivityComponent;
import dev.sadovnikov.daggerpro.MainActivityFeature.MainActivityComponent;
import dev.sadovnikov.daggerpro.MainActivityFeature.MainActivityModule;
import dev.sadovnikov.daggerpro.adapters.RandomUsersRvAdapter;
import dev.sadovnikov.daggerpro.application.RandomUsersApplication;
import dev.sadovnikov.daggerpro.component.DaggerRandomUsersComponent;
import dev.sadovnikov.daggerpro.component.RandomUsersComponent;
import dev.sadovnikov.daggerpro.interfaces.RandomUsersApi;
import dev.sadovnikov.daggerpro.model.RandomUsers;
import dev.sadovnikov.daggerpro.module.ContextModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;
    @Inject
    RandomUsersRvAdapter mAdapter;

    RandomUsersComponent randomUsersComponent;

    @Inject
    RandomUsersApi randomUsersApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUsersComponent(RandomUsersApplication.get(this).getRandomUsersApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);
        Log.d(TAG, "onCreate: " + randomUsersApi);
        Log.d(TAG, "onCreate: " + mAdapter);
//        randomUsersApi = mainActivityComponent.getRandomUsersApi();
//        mAdapter = mainActivityComponent.getRandomUsersRvAdapter();


//        randomUsersComponent = DaggerRandomUsersComponent.builder()
//                .contextModule(new ContextModule(this))
//                .build();
//        Log.d(TAG, "onCreate: " + randomUsersComponent.toString());
        initViews();
//        Timber.plant(new Timber.DebugTree());
        populateUsers();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mAdapter = new RandomUsersRvAdapter(MainActivity.this, randomUsersComponent.getPicasso());
        recyclerView.setAdapter(mAdapter);
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsers = randomUsersApi.getRandomUsers(10);
        randomUsers.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                Timber.d("Resp");
                Log.d(TAG, "onResponse: ");
                mAdapter.setItems(response.body().getResults());
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Timber.i(t);
                //Log.w(TAG, "onFailure: ", t);
            }
        });

//        Call<RandomUsers> randomUsersCall = ApiFactory.getRandomUserServiceApi().getRandomUsers(10);
//        randomUsersCall.enqueue(new Callback<RandomUsers>() {
//            @Override
//            public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
//                if(response.isSuccessful()) {
//                    Timber.d("Resp");
//                    Log.d(TAG, "onResponse: ");
//                    mAdapter.setItems(response.body().getResults());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RandomUsers> call, Throwable t) {
//                Timber.i(t.getMessage());
//                //Log.w(TAG, "onFailure: ", t);
//            }
//        });
    }
}
