package com.example.cocktailssapp.data.local.entities;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.squareup.moshi.Json;

@Entity
public class CocktailEntity {

    @PrimaryKey(autoGenerate = false)
    private int id;
    private String name;
    private @Nullable
    String drinkAlternate;
    private String tags;
    private String category;
    private String type;
    private String glassType;
    private String instructions;
    private String image;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private String ingredient6;

    public CocktailEntity(int id, String name, @Nullable String drinkAlternate, String tags, String category, String type, String glassType, String instructions, String image, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6) {
        this.id = id;
        this.name = name;
        this.drinkAlternate = drinkAlternate;
        this.tags = tags;
        this.category = category;
        this.type = type;
        this.glassType = glassType;
        this.instructions = instructions;
        this.image = image;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getDrinkAlternate() {
        return drinkAlternate;
    }

    public String getTags() {
        return tags;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getGlassType() {
        return glassType;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getImage() {
        return image;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public String getIngredient6() {
        return ingredient6;
    }
}
