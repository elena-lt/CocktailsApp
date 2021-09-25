package com.example.cocktailssapp.data.mappers;

import com.example.cocktailssapp.data.local.entities.CocktailEntity;
import com.example.cocktailssapp.data.remote.responses.Coctail;

import javax.inject.Inject;

public class CocktailMapper {

    @Inject
    public CocktailMapper(){}

    public CocktailEntity toCocktailEntity(Coctail cocktail) {
        return new CocktailEntity(
                cocktail.getId(),
                cocktail.getName(),
                cocktail.getDrinkAlternate(),
                cocktail.getTags(),
                cocktail.getCategory(),
                cocktail.getType(),
                cocktail.getGlassType(),
                cocktail.getInstructions(),
                cocktail.getImage(),
                cocktail.getIngredient1(),
                cocktail.getIngredient2(), cocktail.
                getIngredient3(),
                cocktail.getIngredient4(),
                cocktail.getIngredient5(),
                cocktail.getIngredient6() );
    }
}
