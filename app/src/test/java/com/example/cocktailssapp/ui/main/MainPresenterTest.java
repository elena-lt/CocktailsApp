package com.example.cocktailssapp.ui.main;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.repositories.CocktailsRepository;

import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MainPresenterTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    CoctailsApiService service;

    //InjectMocks used to inject @Mock objects into class
    @InjectMocks
    CocktailsRepository repository;

}