package com.example.cocktailssapp.di;

import android.app.Application;

import com.example.cocktailssapp.BaseApplication;
import com.example.cocktailssapp.di.data.local.RoomModule;
import com.example.cocktailssapp.di.data.remote.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        RoomModule.class,
        ActivityBuildersModule.class
})
public interface AppComponent extends AndroidInjector<BaseApplication>{

//    void inject (BaseApplication baseApplication);
//     void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
