package com.example.cocktailssapp.di.main;

import com.example.cocktailssapp.ui.MainActivity;
import com.example.cocktailssapp.ui.main.MainContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainViewModule {

    @Binds
    abstract MainContract.View provideMainView(MainActivity mainActivity);
}
