package com.example.cocktailssapp.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import javax.inject.Inject;

public class NetworkState {

    Context context;

    @Inject
    public NetworkState (Context context){
        this.context = context;
    }

    public boolean isNetworkAvailable(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            NetworkCapabilities cap = cm.getNetworkCapabilities(cm.getActiveNetwork());

            if (cap == null) return false;
            return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        }else  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network [] networks =cm.getAllNetworks();
            for (Network n: networks){
                NetworkInfo nInfo = cm.getNetworkInfo(n);
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        }else {
            NetworkInfo [] networks = cm.getAllNetworkInfo();
            for (NetworkInfo nInfo: networks){
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        }
        return false;
    }
}
