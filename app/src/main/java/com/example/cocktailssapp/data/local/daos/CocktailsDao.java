package com.example.cocktailssapp.data.local.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import java.util.List;
import javax.inject.Inject;

@Dao
public interface CocktailsDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CocktailEntity> list);

    @Insert
    long insertSingleCocktail(CocktailEntity cocktail);
}
