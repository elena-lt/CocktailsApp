package com.example.cocktailssapp.data.remote.repositories;

import androidx.annotation.Nullable;

import com.example.cocktailssapp.data.local.daos.CocktailsDao;
import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import com.example.cocktailssapp.data.mappers.CocktailMapper;
import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.data.remote.responses.Coctail;
import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import com.example.cocktailssapp.repositories.CocktailsRepository;
import com.example.cocktailssapp.utils.Resource;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

@RunWith(MockitoJUnitRunner.class)
public class CoctailsRepositoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public RxTestSchedulerRule testSchedulerRule = new RxTestSchedulerRule();

    @Mock
    CoctailsApiService service;

    @Mock
    CocktailsDao cocktailsDao;

    @Mock
    Response<CocktailsApiResponse> apiResponse;

    //    InjectMocks used to inject @Mock objects into class
    @InjectMocks
    CocktailsRepository repository;

    CocktailMapper mapper;

    ArrayList<Coctail> list = new ArrayList<>();
    List<CocktailEntity> localData = new ArrayList<>();

    @Before
    public void setup() {

        list.add(new Coctail(1, "test"));
        list.add(new Coctail(2, "anotherTest"));

        localData.add(new CocktailEntity(1, "cocktail1", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        localData.add(new CocktailEntity(2, "cocktail2", "", "", "", "", "", "", "", "", "", "", "", "", ""));

        mapper = new CocktailMapper();

        MockitoAnnotations.openMocks(this);

        repository = new CocktailsRepository(service, cocktailsDao, mapper);
//        repository = Mockito.mock(CocktailsRepository.class);

    }

    @After
    public void teardown() {
    }

    @Test
    public void loadData() {
        CocktailsApiResponse response = new CocktailsApiResponse(list);

        Mockito.when(repository.loadData()).thenReturn(
                Observable.just(response));

        TestObserver<CocktailsApiResponse> testObserver = repository.loadData().test();

        testObserver.assertValue(response);

    }

    @Test
    public void testFetchData_networkAvailable_receiveDataFromNetworkRetrieveFromDb() {
        CocktailsApiResponse response = new CocktailsApiResponse(list);

        setupStubbing(list, localData);

        repository.fetchData();

        Mockito.verify(cocktailsDao).getCocktailsObservable();
        Mockito.verify(cocktailsDao, Mockito.atMostOnce()).insertAll(
                response.getCoctails().stream().map(coctail ->
                        mapper.toCocktailEntity(coctail)).collect(Collectors.toList()));

    }

    @Test
    public void testFetchData_noNetwork_receiveDataFromLocalDb(){
        setupStubbing(null, localData);
        repository.fetchData();
        Mockito.verify(cocktailsDao).getCocktailsObservable();
    }

    private void setupStubbing(@Nullable List<Coctail> dataFromNetwork, @Nullable List<CocktailEntity> dataFromDb) {

        Mockito.when(cocktailsDao.getCocktailsObservable()).thenReturn(Observable.just(dataFromDb));
        Mockito.when(service.getALlCoctails()).thenReturn(Observable.just(Response.success(new CocktailsApiResponse(dataFromNetwork))));
        Mockito.when(apiResponse.body()).thenReturn(new CocktailsApiResponse(dataFromNetwork));

    }
}