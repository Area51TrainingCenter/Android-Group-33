package com.jcodee.mod2class06_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by johannfjs on 13/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ValidarInternetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null &&
                networkInfo.isAvailable() &&
                networkInfo.isConnected()) {
            Toast.makeText(context, "Red conectada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Red no conectada", Toast.LENGTH_SHORT).show();
        }

    }
}
