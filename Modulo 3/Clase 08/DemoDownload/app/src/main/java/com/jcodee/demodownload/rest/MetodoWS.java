package com.jcodee.demodownload.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

/**
 * Created by johannfjs on 4/07/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface MetodoWS {
    @GET("Libros/2012/LYM/padre-Rico-Pobre.pdf")
    @Streaming
    Call<ResponseBody> downloadFile();
}
