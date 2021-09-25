package com.example.cocktailssapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.cocktailssapp.R;
import com.example.cocktailssapp.data.remote.responses.Coctail;
import com.example.cocktailssapp.ui.main.MainContract;
import com.example.cocktailssapp.ui.main.MainPresenter;

import java.util.List;

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
//        presenter.loadData();
        presenter.fetchData();
    }

    @Override
    public void displayData(List<Coctail> list) {

    }
}