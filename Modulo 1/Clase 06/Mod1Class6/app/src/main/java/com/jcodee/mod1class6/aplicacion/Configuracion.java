package com.jcodee.mod1class6.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 11/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializamos la librería de FrecoLib a nivel de aplicación
        Fresco.initialize(getApplicationContext());
    }
}
