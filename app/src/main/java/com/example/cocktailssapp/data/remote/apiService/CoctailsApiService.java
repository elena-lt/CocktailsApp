package com.example.cocktailssapp.data.remote.apiService;

import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface CoctailsApiService {

    @GET("popular.php")
    Observable<CocktailsApiResponse> getCoctails();

}
