package com.jcodee.mod3class1.rest;

import com.jcodee.mod3class1.rest.response.UsuarioResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface MetodosWS {

    @GET("users")
    Call<ArrayList<UsuarioResponse>> obtenerUsuarios();

}
