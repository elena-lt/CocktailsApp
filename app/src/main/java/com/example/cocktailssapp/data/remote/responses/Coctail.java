package com.example.cocktailssapp.data.remote.responses;

import androidx.annotation.Nullable;

import com.squareup.moshi.Json;

public class Coctail {

    @Json(name = "idDrink") private int id;
    @Json(name = "strDrink") private String name;
    @Json(name = "strDrinkAlternate") private @Nullable String drinkAlternate;
    @Json(name = "strTags") private String tags;
    @Json(name = "strCategory") private String category;
    @Json(name = "strAlcoholic") private String type;
    @Json(name = "strGlass") private String glassType;
    @Json(name = "strInstructions") private String instructions;
    @Json(name = "strDrinkThumb") private String image;
    @Json(name = "strIngredient1") private String ingredient1;
    @Json(name = "strIngredient2") private String ingredient2;
    @Json(name = "strIngredient3") private String ingredient3;
    @Json(name = "strIngredient4") private String ingredient4;
    @Json(name = "strIngredient5") private String ingredient5;
    @Json(name = "strIngredient6") private String ingredient6;

    public Coctail(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coctail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drinkAlternate='" + drinkAlternate + '\'' +
                ", tags='" + tags + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", glassType='" + glassType + '\'' +
                ", instructions='" + instructions + '\'' +
                ", image='" + image + '\'' +
                ", ingredient1='" + ingredient1 + '\'' +
                ", ingredient2='" + ingredient2 + '\'' +
                ", ingredient3='" + ingredient3 + '\'' +
                ", ingredient4='" + ingredient4 + '\'' +
                ", ingredient5='" + ingredient5 + '\'' +
                ", ingredient6='" + ingredient6 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDrinkAlternate() {
        return drinkAlternate;
    }

    public void setDrinkAlternate(@Nullable String drinkAlternate) {
        this.drinkAlternate = drinkAlternate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public void setIngredient4(String ingredient4) {
        this.ingredient4 = ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public void setIngredient5(String ingredient5) {
        this.ingredient5 = ingredient5;
    }

    public String getIngredient6() {
        return ingredient6;
    }

    public void setIngredient6(String ingredient6) {
        this.ingredient6 = ingredient6;
    }
}
