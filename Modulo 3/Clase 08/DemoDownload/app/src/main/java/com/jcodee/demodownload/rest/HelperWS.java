package com.jcodee.demodownload.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johannfjs on 4/07/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HelperWS {
    public static Retrofit getConfiguration() {
        return new Retrofit.Builder()
                .baseUrl("http://biblio3.url.edu.gt/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
