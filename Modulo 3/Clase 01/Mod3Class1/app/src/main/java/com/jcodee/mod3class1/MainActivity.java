package com.jcodee.mod3class1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jcodee.mod3class1.adapters.DatoAdapter;
import com.jcodee.mod3class1.rest.HelperWS;
import com.jcodee.mod3class1.rest.MetodosWS;
import com.jcodee.mod3class1.rest.response.UsuarioResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnObtener)
    public void onViewClicked() {
        //Mapear las rutas del servicio de WS
        MetodosWS metodosWS = HelperWS.obtenerConfiguracion().create(MetodosWS.class);
        //Crear y llamar el metodo a consumir
        Call<ArrayList<UsuarioResponse>> listCall = metodosWS.obtenerUsuarios();
        //Llamar al meotod y agregarlo a la cola de peticiones
        listCall.enqueue(new Callback<ArrayList<UsuarioResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UsuarioResponse>> call, Response<ArrayList<UsuarioResponse>> response) {

                ArrayList<UsuarioResponse> datos = response.body();
                if (datos != null) {
                    DatoAdapter datoAdapter = new DatoAdapter(MainActivity.this, datos);
                    rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvDatos.setAdapter(datoAdapter);

                    Toast.makeText(MainActivity.this, "Se obtuvieron datos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "No se obtuvieron datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UsuarioResponse>> call, Throwable t) {

            }
        });

    }
}
