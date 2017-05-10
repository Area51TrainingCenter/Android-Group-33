package com.jcodee.mod1class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.mod1class4.modelos.Noticia;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spPeriodico, spCategoria;
    private EditText etTitulo;
    private RadioButton rbAprobado, rbRechazado;
    private Button btnRegistro, btnVerTodo;

    public static ArrayList<Noticia> listaNoticias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPeriodico = (Spinner) findViewById(R.id.spPeriodico);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);
        etTitulo = (EditText) findViewById(R.id.etTitulo);
        rbAprobado = (RadioButton) findViewById(R.id.rbAprobado);
        rbRechazado = (RadioButton) findViewById(R.id.rbRechazado);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnVerTodo = (Button) findViewById(R.id.btnVerTodo);

        //rbAprobado.setChecked(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Declaramos una lista la cual va a tener los elementos que se mostrarán en el spinner
        final ArrayList<String> listaDatos = new ArrayList<>();
        //Agregamos elementos a la lista
        listaDatos.add("Portada");
        listaDatos.add("Deporte");
        listaDatos.add("Cine");

        //Creamos un arrayAdapter o una estructura para nuestro spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                listaDatos);
        //Cambiamos el adapter que viene por defecto en el spinner de categoría
        spCategoria.setAdapter(arrayAdapter);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String periodico = spPeriodico.getSelectedItem().toString();
                String categira = spCategoria.getSelectedItem().toString();
                String titulo = etTitulo.getText().toString();

                /*
                boolean aprobado = false;
                if (rbAprobado.isChecked()) {
                    aprobado = true;
                } else if (rbRechazado.isChecked()) {
                    aprobado = false;
                }
                */

                //                  condicion ? respuesta_positiva : respuesta_negativa
                boolean aprobado = (rbAprobado.isChecked() ? true :
                        (rbRechazado.isChecked() ? false : false));

                //creamos un objeto de tipo noticia y le seteamos los datos que hemos obtenido
                Noticia noticia = new Noticia();
                noticia.setId(listaNoticias.size() + 1);
                noticia.setTitulo(titulo);
                noticia.setAprobado(aprobado);
                noticia.setCategoria(categira);
                noticia.setPeriodico(periodico);

                //Agregamos una noticia al listado
                listaNoticias.add(noticia);

                //Mostramos un mensaje de confirmación
                Toast.makeText(MainActivity.this, "Se registro", Toast.LENGTH_SHORT).show();

            }
        });
        btnVerTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
