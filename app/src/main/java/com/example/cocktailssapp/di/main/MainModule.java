package com.example.cocktailssapp.di.main;

import android.util.Log;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.ui.main.MainContract;
import com.example.cocktailssapp.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    CocktailsRepository provideCoctailsRepository(CoctailsApiService apiService){
        Log.d("AppDebug", "provideCoctailsRepository: repo instantiated ");
        return new CocktailsRepository(apiService);
    }

    @Provides
    MainPresenter provideMainPresenter(MainContract.View view, CocktailsRepository repository){
        Log.d("AppDebug", "provideMainPresenter instantiated");
        return new MainPresenter(view, repository);
    }
}
