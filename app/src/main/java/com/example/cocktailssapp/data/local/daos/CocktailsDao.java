package com.example.cocktailssapp.data.local.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cocktailssapp.data.local.entities.CocktailEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface CocktailsDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CocktailEntity> list);

    @Insert
    long insertSingleCocktail(CocktailEntity cocktail);

    @Query("SELECT * FROM tb_cocktails")
    List<CocktailEntity> getCocktails();

    @Query("SELECT * FROM tb_cocktails")
    Observable<List<CocktailEntity>> getCocktailsObservable();
}
