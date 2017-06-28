package com.jcodee.mod3class2.rest;

import com.jcodee.mod3class2.rest.response.LoginResponse;
import com.jcodee.mod3class2.rest.response.RegistroResponse;
import com.jcodee.mod3class2.rest.response.UsuarioResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by johannfjs on 27/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface MetodoWS {
    @GET("users")
    Call<ArrayList<UsuarioResponse>> obtenerUsuarios();

    @POST("posts")
    @FormUrlEncoded
    Call<RegistroResponse> registrarPost(@Field("title") String title,
                                         @Field("body") String body,
                                         @Field("userId") int userId);

    @POST("al_login.php")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("NAME") String name,
                              @Field("PASSWORD") String password);
}
