package com.johannfjs.mod2class4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.EditText;
import android.widget.Toast;

import com.johannfjs.mod2class4_1.database.SentenciaSQL;
import com.johannfjs.mod2class4_1.entidad.PersonaEntidad;

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
    @BindView(R.id.etNumero)
    EditText etNumero;
    @BindView(R.id.tilNumero)
    TextInputLayout tilNumero;
    @BindView(R.id.etDireccion)
    EditText etDireccion;
    @BindView(R.id.tilDireccion)
    TextInputLayout tilDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegistrar)
    public void onBtnRegistrarClicked() {

        //Obtener los valores ingresados en los componentes
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String numero = etNumero.getText().toString();
        String direccion = etDireccion.getText().toString();

        //Preguntamos si el campo está vacío
        if (nombre.isEmpty()) {
            //Si está vacío, mostramos un mensaje y salimos del método
            tilNombre.setError("Campo es requerido");
            return;
        } else {
            //Si no está vacío limpiamos el mensaje y continuamos
            tilNombre.setError(null);
        }
        if (apellido.isEmpty()) {
            tilApellido.setError("Campo es requerido");
            return;
        } else {
            tilApellido.setError(null);
        }
        if (numero.isEmpty()) {
            tilNumero.setError("Campo es requerido");
            return;
        } else {
            tilNumero.setError(null);
        }
        if (direccion.isEmpty()) {
            tilDireccion.setError("Campo es requerido");
            return;
        } else {
            tilDireccion.setError(null);
        }

        SentenciaSQL sentenciaSQL = new SentenciaSQL();

        PersonaEntidad personaEntidad = new PersonaEntidad();
        personaEntidad.setId(sentenciaSQL.obtenerSiguienteId());
        personaEntidad.setNombre(nombre);
        personaEntidad.setApellido(apellido);
        personaEntidad.setNumero(numero);
        personaEntidad.setDireccion(direccion);
        sentenciaSQL.insertar(personaEntidad);

        Toast.makeText(this, "Se registro", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btnVerTodos)
    public void onBtnVerTodosClicked() {

        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
        startActivity(intent);

    }
}
