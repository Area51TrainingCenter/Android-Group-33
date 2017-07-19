package com.jcodee.mod3class6.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by johannfjs on 18/07/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990 870 011
 */

public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                Toast.makeText(context, "Internet activo", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Internet inactivo", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Internet inactivo", Toast.LENGTH_SHORT).show();
        }
    }
}
