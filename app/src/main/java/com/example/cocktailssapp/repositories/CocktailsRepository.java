package com.example.cocktailssapp.repositories;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.cocktailssapp.data.local.daos.CocktailsDao;
import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import com.example.cocktailssapp.data.mappers.CocktailMapper;
import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import com.example.cocktailssapp.utils.Resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CocktailsRepository {

    CoctailsApiService apiService;
    CocktailsDao cocktailsDao;
    CocktailMapper mapper;

    @Inject
    public CocktailsRepository(CoctailsApiService apiService, CocktailsDao cocktailsDao, CocktailMapper mapper) {
        this.apiService = apiService;
        this.cocktailsDao = cocktailsDao;
        this.mapper = mapper;
    }

    public Observable<CocktailsApiResponse> loadData() {
        return apiService.getCoctails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Resource<List<CocktailEntity>>> fetchData() {
        return new NetworkBoundResource<CocktailsApiResponse, List<CocktailEntity>>(true, true) {

            @Override
            Observable<List<CocktailEntity>> loadFromCache() {
                return cocktailsDao.getCocktailsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }

            @Override
            Observable<Resource<CocktailsApiResponse>> fetchData() {
                return apiService.getALlCoctails().flatMap(response ->
                        Observable.just(response.isSuccessful() ? Resource.success(response.body())
                                : Resource.error(response.message(), null)));
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            protected void saveDataToDb(CocktailsApiResponse data) {
                if (data.getCoctails().size() > 1) {
                    List<CocktailEntity> list = data.getCoctails().stream().map(coctail -> mapper.toCocktailEntity(coctail)).collect(Collectors.toList());
                    Scheduler.Worker worker = Schedulers.io().createWorker();
                    worker.schedule(() -> cocktailsDao.insertAll(list));
                }
            }
        }.asObservable();
    }

}
