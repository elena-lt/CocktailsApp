package com.example.cocktailssapp.di.data.local;

import android.app.Application;

import androidx.room.Room;

import com.example.cocktailssapp.data.local.AppDatabase;
import com.example.cocktailssapp.data.local.daos.CocktailsDao;
import com.example.cocktailssapp.utils.Const;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Application app){
        return Room.databaseBuilder(app, AppDatabase.class, Const.DATABASE_NAME).build();
    }

    @Provides
    @Singleton
    public CocktailsDao provideCocktailsDao(AppDatabase db){
        return db.provideCocktailsDao();
    };
}
