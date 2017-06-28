package com.jcodee.mod3class2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod3class2.rest.HelperWS;
import com.jcodee.mod3class2.rest.MetodoWS;
import com.jcodee.mod3class2.rest.response.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUsuario)
    EditText etUsuario;
    @BindView(R.id.etContrasena)
    EditText etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        String usuario = etUsuario.getText().toString();
        String contrasena = etContrasena.getText().toString();

        if (usuario.isEmpty()) {
            etUsuario.setError("El campo es requerido");
            return;
        }
        if (contrasena.isEmpty()) {
            etContrasena.setError("El campo es requerido");
            return;
        }
        //yannoss           friki
        MetodoWS metodoWS = HelperWS.obtenerConfiguracion2().create(MetodoWS.class);
        Call<LoginResponse> responseCall = metodoWS.login(usuario, contrasena);
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse result = response.body();
                if (result.getSuccess() == 1) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario y/o contraseña erroneo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
