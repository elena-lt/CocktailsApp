package com.example.cocktailssapp.data.remote.repositories;

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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class CoctailsRepositoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public RxTestSchedulerRule testSchedulerRule = new RxTestSchedulerRule();

    @Mock
    CoctailsApiService service;

//    InjectMocks used to inject @Mock objects into class
    @InjectMocks
CocktailsRepository repository;

    ArrayList<Coctail> list = new ArrayList<>();

    @Before
    public void setup(){

        list.add(new Coctail(1, "test"));
        list.add (new Coctail(2, "anotherTest"));

        MockitoAnnotations.openMocks(this);
        repository = Mockito.mock(CocktailsRepository.class);

    }

    @After
    public void teardown(){
    }

    @Test
    public void loadData() {
        CocktailsApiResponse response = new CocktailsApiResponse(list);

        Mockito.when(repository.loadData()).thenReturn(
                Observable.just(response));

        TestObserver<CocktailsApiResponse> testObserver = repository.loadData().test();

        testObserver.assertValue(response);

    }

}