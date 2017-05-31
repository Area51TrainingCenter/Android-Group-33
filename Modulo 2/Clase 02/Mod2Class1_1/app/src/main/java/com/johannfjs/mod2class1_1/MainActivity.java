package com.johannfjs.mod2class1_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.johannfjs.mod2class1_1.sqlite.SentenciaSQL;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spTema)
    Spinner spTema;
    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etDescripcion)
    EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);
        ArrayList<String> lista = sentenciaSQL.obtenerTemas();

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lista);
        spTema.setAdapter(arrayAdapter);
    }

    @OnClick(R.id.btnListado)
    public void onBtnListadoClicked() {

        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btnGuardar)
    public void onBtnGuardarClicked() {

        SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);

        String tema = spTema.getSelectedItem().toString();
        String titulo = etTitulo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        int idTema = sentenciaSQL.obtenerTemas(tema);

        sentenciaSQL.insertarElemento(idTema, titulo, descripcion);

        Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();

    }
}
