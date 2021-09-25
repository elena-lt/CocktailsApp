package com.example.cocktailssapp.ui.main;

import android.util.Log;

import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import com.example.cocktailssapp.utils.Resource;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    CocktailsRepository repository;

    public MainPresenter(MainContract.View view, CocktailsRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadData() {
        repository.loadData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CocktailsApiResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CocktailsApiResponse coctailsApiResponse) {
                        view.displayData(coctailsApiResponse.getCoctails());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void fetchData(){
        repository.fetchData().subscribe(new Observer<Resource<List<CocktailEntity>>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Resource<List<CocktailEntity>> listResource) {
                Log.d("AppDebug", "onNext: ");
                assert listResource.data != null;
                Log.d("AppDebug", "onNext: " + listResource.data.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("AppDebug", "onError: ");
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
