package com.example.cocktailssapp;

import com.example.cocktailssapp.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


//    AppComponent appComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        appComponent = DaggerAppComponent.create();
//    }
//    public AppComponent getAppComponent(){return appComponent;}
}
