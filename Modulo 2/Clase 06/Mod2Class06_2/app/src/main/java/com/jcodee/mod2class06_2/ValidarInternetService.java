package com.jcodee.mod2class06_2;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by johannfjs on 13/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ValidarInternetService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null &&
                networkInfo.isAvailable() &&
                networkInfo.isConnected()) {
            Toast.makeText(this, "Red conectada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Red no conectada", Toast.LENGTH_SHORT).show();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Se detuvo servicio", Toast.LENGTH_SHORT).show();

    }
}
