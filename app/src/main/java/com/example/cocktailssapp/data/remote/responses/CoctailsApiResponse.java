package com.example.cocktailssapp.data.remote.responses;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class CoctailsApiResponse {

    @Json(name = "drinks")
    private List<Coctail> coctails;

    public CoctailsApiResponse(List<Coctail> coctails) {
        this.coctails = coctails;
    }

    public List<Coctail> getCoctails() {
        return coctails;
    }

    public void setCoctails(ArrayList<Coctail> coctails) {
        this.coctails = coctails;
    }
}


