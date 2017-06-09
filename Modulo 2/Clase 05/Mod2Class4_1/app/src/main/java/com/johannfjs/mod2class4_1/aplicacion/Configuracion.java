package com.johannfjs.mod2class4_1.aplicacion;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by johannfjs on 6/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Realm configuración
        Realm.init(getApplicationContext());

        //Creamos la nueva configuración de la base de datos
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("class4.realm")
                .schemaVersion(1)
                .build();

        //Cambiamos la configuración por defecto por la nueva configurada
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
