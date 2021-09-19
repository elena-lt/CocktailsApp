package com.example.cocktailssapp.di;

import com.example.cocktailssapp.di.main.MainModule;
import com.example.cocktailssapp.di.main.MainViewModule;
import com.example.cocktailssapp.ui.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector (modules = {MainModule.class, MainViewModule.class})
    abstract MainActivity contributeMainActivity();
}
