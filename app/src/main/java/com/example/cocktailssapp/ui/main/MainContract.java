package com.example.cocktailssapp.ui.main;

import com.example.cocktailssapp.data.remote.responses.Coctail;

import java.util.List;

public interface MainContract {

    interface Presenter {
        void loadData();
    }

    interface View {
        void displayData(List<Coctail> list);
    }
}
