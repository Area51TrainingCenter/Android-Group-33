package com.johannfjs.mod2class03.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 1/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());
    }
}
