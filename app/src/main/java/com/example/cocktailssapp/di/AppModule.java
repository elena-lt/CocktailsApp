package com.example.cocktailssapp.di;

import android.app.Application;

import com.example.cocktailssapp.utils.NetworkState;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    NetworkState provideNetworkStateUtil(Application application){
        return new NetworkState(application.getApplicationContext());
    }

}
