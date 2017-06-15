package com.jcodee.mod2class06_2.aplicacion;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.jcodee.mod2class06_2.ValidarInternetReceiver;

/**
 * Created by johannfjs on 13/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter(Context.CONNECTIVITY_SERVICE);
        registerReceiver(new ValidarInternetReceiver(), intentFilter);
    }
}
