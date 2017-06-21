package com.jcodee.mod2class7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class7.database.MetodosRealm;
import com.jcodee.mod2class7.entidades.Usuario;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etUsuario)
    EditText etUsuario;
    @BindView(R.id.tilUsuario)
    TextInputLayout tilUsuario;
    @BindView(R.id.etContrasenia)
    EditText etContrasenia;
    @BindView(R.id.tilContrasenia)
    TextInputLayout tilContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Creamos un share preferences en modo privado
        SharedPreferences sharedPreferences = getSharedPreferences("class7", MODE_PRIVATE);
        //Consultamos si existe la preferencia almacenada
        boolean resultado = sharedPreferences.contains("usuario");
        if (resultado) {
            //Si existe el registro guardado, se podrá pasar a la pantalla principal
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.btnIniciarSesion)
    public void onBtnIniciarSesionClicked() {

        String usuario = etUsuario.getText().toString();
        String contrasenia = etContrasenia.getText().toString();

        if (usuario.isEmpty()) {
            tilUsuario.setError("Campo es requerido");
            return;
        } else tilUsuario.setError(null);

        Usuario validarUsuario = MetodosRealm.validarUsuario(usuario, contrasenia);
        if (validarUsuario != null) {

            SharedPreferences.Editor sharedPreferences =
                    getSharedPreferences("class7", MODE_PRIVATE).edit();
            sharedPreferences.putString("usuario", usuario);
            sharedPreferences.apply();

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Debe de completar todos los campos",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btnCrearCuenta)
    public void onBtnCrearCuentaClicked() {

        Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
        startActivity(intent);
    }
}
