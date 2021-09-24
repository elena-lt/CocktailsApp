package com.example.cocktailssapp.data.local.daos;

import android.content.Context;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnitRunner;

import com.example.cocktailssapp.data.local.AppDatabase;
import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@RunWith(AndroidJUnit4.class)
public class CocktailsDaoTest {

    AppDatabase database;
    CocktailsDao dao;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        dao = database.provideCocktailsDao();
    }

    @After
    public void teardown() {
        database.close();
    }

    @Test
    public void testInsertAndRetrieveCocktails() {

        CocktailEntity cocktail1 = new CocktailEntity(1, "cocktail1", "", "", "", "", "", "", "", "", "", "", "", "", "");
        CocktailEntity cocktail2 = new CocktailEntity(2, "cocktail2", "", "", "", "", "", "", "", "", "", "", "", "", "");
        List<CocktailEntity> list = new ArrayList<>();
        list.add(cocktail1);
        list.add(cocktail2);

        dao.insertAll(list);

        List<CocktailEntity> allCocktails = dao.getCocktails();

        Truth.assertThat (list.equals(allCocktails));

    }

}