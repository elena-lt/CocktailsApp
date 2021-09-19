package com.example.cocktailssapp.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cocktailssapp.data.local.daos.CocktailsDao;
import com.example.cocktailssapp.data.local.entities.CocktailEntity;

@Database(entities = {CocktailEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CocktailsDao provideCocktailsDao();
}
