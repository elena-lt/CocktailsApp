package com.example.cocktailssapp.ui.main;

import android.util.Log;

import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.data.remote.responses.CoctailsApiResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    CocktailsRepository repository;

    public MainPresenter(MainContract.View view, CocktailsRepository repository) {
        Log.d("AppDebug", "MainPresenter: instantiated");
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadData() {
        repository.loadData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CoctailsApiResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CoctailsApiResponse coctailsApiResponse) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
