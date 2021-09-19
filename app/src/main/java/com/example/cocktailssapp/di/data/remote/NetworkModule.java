package com.example.cocktailssapp.di.data.remote;

import com.example.cocktailssapp.data.remote.apiService.CoctailsApiService;
import com.example.cocktailssapp.utils.Const;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

//    @Provides
//    @Named("BASE_URL")
//    public String provideBaseUrl() {
//        return Const.BASE_URL;
//    }

    @Provides
    @Singleton
    public Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.addInterceptor(interceptor);

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "1149dbf400msh6d8702696eded64p113dd9jsnfaab9c5cad66").build();
            return chain.proceed(request);
        });

        return builder.build();
    }

    @Provides
    public Retrofit provideRetrofit( Moshi moshi, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
    }

    @Provides
    @Singleton
    CoctailsApiService provideCoctailsApiService(Retrofit retrofit) {
        return retrofit.create(CoctailsApiService.class);
    }
}
