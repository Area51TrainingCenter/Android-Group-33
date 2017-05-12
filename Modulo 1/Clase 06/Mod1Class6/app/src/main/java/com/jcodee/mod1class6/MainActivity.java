package com.jcodee.mod1class6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod1class6.modelos.Galeria;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etTitulo, etDescripcion;
    private Button btnRegistrar, btnGaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = (EditText) findViewById(R.id.etTitulo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        btnGaleria = (Button) findViewById(R.id.btnGaleria);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
    }

    public static ArrayList<Galeria> listaFotos = new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Galeria galeria = new Galeria();
                galeria.setId(listaFotos.size() + 1);
                galeria.setDescripcion(etDescripcion.getText().toString());
                galeria.setTitulo(etTitulo.getText().toString());
                galeria.setRutaImagen("http://www.definicionabc.com/wp-content/uploads/Paisaje-Natural.jpg");
                listaFotos.add(galeria);

                Toast.makeText(MainActivity.this,
                        "Se registro correctamente", Toast.LENGTH_SHORT).show();

            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, GaleriaActivity.class);
                startActivity(intent);

            }
        });
    }
}
