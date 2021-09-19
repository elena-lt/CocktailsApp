package com.example.cocktailssapp.ui.main;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.data.remote.responses.Coctail;
import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.utils.RxTestSchedulerRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public RxTestSchedulerRule testScheduleRule = new RxTestSchedulerRule();

    @Mock
    CoctailsApiService service;

    //    @Mock
    CocktailsRepository repository;

    @Mock
    MainContract.View view;

    MainPresenter presenter;

    ArrayList<Coctail> list = new ArrayList();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        repository = Mockito.mock(CocktailsRepository.class);
        presenter = new MainPresenter(view, repository);

        list.add(new Coctail(1, "test"));
        list.add(new Coctail(2, "anotherTest"));
    }


    @Test
    public void loadData() {
        CocktailsApiResponse response = new CocktailsApiResponse(list);

        Mockito.when(repository.loadData()).thenReturn(Observable.just(response));

        presenter.loadData();

        Mockito.verify(view).displayData(response.getCoctails());

    }

    @After
    public void teardown() {
        presenter = null;
    }
}