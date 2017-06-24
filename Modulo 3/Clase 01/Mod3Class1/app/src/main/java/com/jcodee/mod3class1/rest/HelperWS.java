package com.jcodee.mod3class1.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HelperWS {
    /*
    GET         obtener datos
    POST        enviar datos
    PUT         actualizar datos
    DELETE      eliminar datos
     */

    //Obtener la configuración del json
    public static Retrofit obtenerConfiguracion() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
