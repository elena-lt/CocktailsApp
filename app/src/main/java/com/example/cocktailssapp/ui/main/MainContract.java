package com.example.cocktailssapp.ui.main;

public interface MainContract {

    interface Presenter {
        void loadData();
    }

    interface View {
        void displayData();
    }
}
