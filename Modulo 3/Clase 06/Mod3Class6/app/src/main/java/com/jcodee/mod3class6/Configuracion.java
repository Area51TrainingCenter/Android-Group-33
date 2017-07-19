package com.jcodee.mod3class6;

import android.app.Application;
import android.content.IntentFilter;

import com.jcodee.mod3class6.service.InternetReceiver;

/**
 * Created by johannfjs on 18/07/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990 870 011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter(CONNECTIVITY_SERVICE);
        registerReceiver(new InternetReceiver(), intentFilter);
    }
}
