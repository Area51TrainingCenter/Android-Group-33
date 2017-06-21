package com.jcodee.mod2class7;

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

public class RegistrarActivity extends AppCompatActivity {

    @BindView(R.id.etUsuario)
    EditText etUsuario;
    @BindView(R.id.tilUsuario)
    TextInputLayout tilUsuario;
    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.tilNombre)
    TextInputLayout tilNombre;
    @BindView(R.id.etApellido)
    EditText etApellido;
    @BindView(R.id.tilApellido)
    TextInputLayout tilApellido;
    @BindView(R.id.etContrasenia)
    EditText etContrasenia;
    @BindView(R.id.tilContrasenia)
    TextInputLayout tilContrasenia;
    @BindView(R.id.etRepContrasenia)
    EditText etRepContrasenia;
    @BindView(R.id.tilResContrasenia)
    TextInputLayout tilResContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCrearCuenta)
    public void onViewClicked() {

        String usuario = etUsuario.getText().toString();
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        String repContrasenia = etRepContrasenia.getText().toString();

        if (contrasenia.equals(repContrasenia)) {

            Usuario usuario1 = new Usuario();
            usuario1.setId(MetodosRealm.nextId());
            usuario1.setNombre(nombre);
            usuario1.setUsuario(usuario);
            usuario1.setApellido(apellido);
            usuario1.setContrasenia(contrasenia);

            MetodosRealm.registrarPersona(usuario1);
            Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
            finish();

        } else {
            Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }
}
