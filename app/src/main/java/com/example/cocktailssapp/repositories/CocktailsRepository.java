package com.example.cocktailssapp.repositories;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CocktailsRepository {

    CoctailsApiService apiService;

    @Inject
    public CocktailsRepository(CoctailsApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<CocktailsApiResponse> loadData() {
        return
                apiService.getCoctails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
