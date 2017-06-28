package com.jcodee.mod3class2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.mod3class2.rest.HelperWS;
import com.jcodee.mod3class2.rest.MetodoWS;
import com.jcodee.mod3class2.rest.response.RegistroResponse;
import com.jcodee.mod3class2.rest.response.UsuarioResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spUsuarios)
    Spinner spUsuarios;
    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etCuerpo)
    EditText etCuerpo;

    private ArrayList<UsuarioResponse> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MetodoWS metodoWS = HelperWS.obtenerConfiguracion().create(MetodoWS.class);
        Call<ArrayList<UsuarioResponse>> listCall = metodoWS.obtenerUsuarios();
        listCall.enqueue(new Callback<ArrayList<UsuarioResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UsuarioResponse>> call, Response<ArrayList<UsuarioResponse>> response) {
                list = response.body();
                ArrayList<String> usuarios = new ArrayList<String>();
                for (UsuarioResponse item : list) {
                    usuarios.add(item.getName());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        usuarios);
                spUsuarios.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<UsuarioResponse>> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btnGuardar)
    public void onViewClicked() {
        String usuario = spUsuarios.getSelectedItem().toString();
        String titulo = etTitulo.getText().toString();
        String cuerpo = etCuerpo.getText().toString();

        if (titulo.isEmpty()) {
            etTitulo.setError("El campo es requerido");
            return;
        }
        if (cuerpo.isEmpty()) {
            etCuerpo.setError("El campo es requerido");
            return;
        }

        int idUser = 0;
        for (UsuarioResponse item : list) {
            if (item.getName().equals(usuario)) {
                idUser = item.getId();
                break;
            }
        }

        MetodoWS metodoWS = HelperWS.obtenerConfiguracion().create(MetodoWS.class);
        Call<RegistroResponse> responseCall = metodoWS.registrarPost(titulo, cuerpo, idUser);
        responseCall.enqueue(new Callback<RegistroResponse>() {
            @Override
            public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
                RegistroResponse result = response.body();
                Toast.makeText(MainActivity.this, "->" + result.getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegistroResponse> call, Throwable t) {

            }
        });

    }
}
