package com.example.cocktailssapp.di.main;

import android.util.Log;

import com.example.cocktailssapp.data.local.daos.CocktailsDao;
import com.example.cocktailssapp.data.mappers.CocktailMapper;
import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.ui.main.MainContract;
import com.example.cocktailssapp.ui.main.MainPresenter;
import com.example.cocktailssapp.utils.NetworkState;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    CocktailsRepository provideCoctailsRepository(
            CoctailsApiService apiService,
            CocktailsDao cocktailsDao,
            CocktailMapper mapper,
            NetworkState networkState) {
        return new CocktailsRepository(apiService, cocktailsDao, mapper, networkState);
    }

    @Provides
    MainPresenter provideMainPresenter(MainContract.View view, CocktailsRepository repository) {
        return new MainPresenter(view, repository);
    }
}
