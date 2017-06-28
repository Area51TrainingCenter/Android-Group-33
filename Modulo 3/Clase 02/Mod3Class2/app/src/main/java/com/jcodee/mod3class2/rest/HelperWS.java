package com.jcodee.mod3class2.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johannfjs on 27/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HelperWS {
    public static Retrofit obtenerConfiguracion() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit obtenerConfiguracion2() {
        return new Retrofit.Builder()
                .baseUrl("http://www.kanashiro.com.pe/alpha/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
