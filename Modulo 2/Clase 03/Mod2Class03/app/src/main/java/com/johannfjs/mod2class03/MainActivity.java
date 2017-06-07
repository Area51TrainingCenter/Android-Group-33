package com.johannfjs.mod2class03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.johannfjs.mod2class03.modelos.Persona;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.tilNombre)
    TextInputLayout tilNombre;
    @BindView(R.id.etApellido)
    EditText etApellido;
    @BindView(R.id.tilApellido)
    TextInputLayout tilApellido;

    public static ArrayList<Persona> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnGuardar)
    public void onBtnGuardarClicked() {

        //Obtenemos los datos
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();

        boolean boolNombre = false, boolApellido = false;

        //Validamos que el campo nombre tenga información
        if (nombre.isEmpty()) {
            //Si es que es vacío mostramos un mensaje de error y sale del método
            tilNombre.setError("Campo es requerido");
            boolNombre = false;
        } else {
            //Si está ok, limpiamos el mensaje de error
            tilNombre.setError(null);
            boolNombre = true;
        }

        if (apellido.isEmpty()) {
            tilApellido.setError("Campo es requerido");
            boolApellido = false;
        } else {
            tilApellido.setError(null);
            boolApellido = true;
        }

        if (boolNombre && boolApellido) {
            Persona persona = new Persona();
            persona.setId(listaPersonas.size() + 1);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            listaPersonas.add(persona);
            Toast.makeText(this, "Se registro.", Toast.LENGTH_SHORT).show();

            etNombre.setText("");
            etApellido.setText("");
        }
    }

    @OnClick(R.id.btnListar)
    public void onBtnListarClicked() {

        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
        startActivity(intent);

    }
}
