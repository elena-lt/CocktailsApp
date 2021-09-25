package com.example.cocktailssapp.repositories;

import android.util.Log;

import com.example.cocktailssapp.utils.Resource;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

abstract class NetworkBoundResource<RequestType, ResultType> {

    private boolean shouldLoadFromCache;
    private boolean shouldFetch;
    private boolean isNetworkAvailable;
    private Observable<Resource<ResultType>> result;

    public NetworkBoundResource(boolean shouldFetch, boolean shouldLoadFromCache) {
        this.shouldFetch = shouldFetch;
        this.shouldLoadFromCache = shouldLoadFromCache;
        init();
    }

    void init() {
        Observable<Resource<ResultType>> source;
        if (shouldFetch) {
            source = fetchData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(apiResponse -> saveDataToDb(processData(apiResponse)))
                    .flatMap(apiResponse -> loadFromCache().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(Resource::success))
                    .doOnError(this::onFetchFailed);
        } else {
            source = loadFromCache()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(Resource::success);
        }

        result = Observable.concat(
                loadFromCache()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(Resource::loading)
                        .take(1),
                source
        );
    }

    abstract Observable<ResultType> loadFromCache();

    abstract Observable<Resource<RequestType>> fetchData();

    protected void saveDataToDb(RequestType data) {
    }

    protected RequestType processData(Resource<RequestType> data) {
        if (data.data != null) return data.data;
        else return null;
//        return data.data;
    }

    protected void onFetchFailed(Throwable throwable) {
        Log.d("AppDebug", "onFetchFailed: " + throwable);
    }

    protected Observable<Resource<ResultType>> asObservable() {
        return result;
    }

}
