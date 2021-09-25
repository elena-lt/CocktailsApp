package com.example.cocktailssapp.data.remote.apiService;

import com.example.cocktailssapp.data.remote.responses.CocktailsApiResponse;
import com.example.cocktailssapp.utils.Resource;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface CoctailsApiService {

    @GET("popular.php")
    Observable<CocktailsApiResponse> getCoctails();

    @GET("popular.php")
    Observable<Response<CocktailsApiResponse>> getALlCoctails();

}
