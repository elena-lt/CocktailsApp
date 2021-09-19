package com.example.cocktailssapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.cocktailssapp.R;
import com.example.cocktailssapp.ui.main.MainContract;
import com.example.cocktailssapp.ui.main.MainPresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;

    CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCoctails();
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }

    private void getCoctails() {
        presenter.loadData();
//                .subscribe(new Observer<CoctailsApiResponse>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                disposable.add(d);
//                Log.d("AppDebug", "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(@NonNull CoctailsApiResponse coctailsApiResponse) {
//                Log.d("AppDebug", "onNext: " + coctailsApiResponse.getCoctails().toString());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d("AppDebug", "onError: ");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("AppDebug", "onComplete: ");
//            }
//        });

    }

    @Override
    public void displayData() {
        Log.d("AppDebug", "displayData: ");
    }
}