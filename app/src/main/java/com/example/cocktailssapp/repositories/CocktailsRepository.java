package com.example.cocktailssapp.repositories;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.data.remote.responses.CoctailsApiResponse;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CocktailsRepository {

    CoctailsApiService apiService;

    @Inject
    public CocktailsRepository(CoctailsApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<CoctailsApiResponse> loadData() {
        return apiService.getCoctails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
