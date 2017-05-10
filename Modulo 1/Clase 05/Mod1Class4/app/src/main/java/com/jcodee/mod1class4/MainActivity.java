package com.jcodee.mod1class4;

import android.content.Intent;
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

        //Tag - soporta cualquier tipo de dato, es como un comodin
        btnRegistro.setTag(-1);

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

        String[] listaPeriodicos = getResources().getStringArray(R.array.periodicos);

        //Validamos que el intent traiga datos
        if (getIntent() != null) {
            //Validamos que el intent traiga el registro con la llave de posicion
            if (getIntent().hasExtra("posicion")) {
                //Obtenemos el dato envaido en la llave de posicion
                int posicion = getIntent().getIntExtra("posicion", -1);
                if (posicion >= 0) {
                    //Obtenemos el registro de la lista
                    Noticia noticia = listaNoticias.get(posicion);
                    //Setear los datos para poder mostrarlos en los componentes
                    etTitulo.setText(noticia.getTitulo());
                    if (noticia.isAprobado()) {
                        rbAprobado.setChecked(true);
                    } else {
                        rbRechazado.setChecked(true);
                    }

                    //creamos una variable de tipo entera que servira de contador
                    int conCat = 0;
                    //recorremos la lista para poder obtener los datos
                    for (String categoria : listaDatos) {
                        if (noticia.getCategoria().equals(categoria)) {
                            //Cambiamos la selección por defecto del combo
                            spCategoria.setSelection(conCat);
                            break;
                        }
                        //Agregamos un valor a la variable
                        conCat++;
                    }
                    //creamos una variable de tipo entera que servira de contador
                    int conPer = 0;
                    //recorremos la lista para poder obtener los datos
                    for (String periodico : listaPeriodicos) {
                        if (noticia.getPeriodico().equals(periodico)) {
                            //Cambiamos la selección por defecto del combo
                            spPeriodico.setSelection(conPer);
                            break;
                        }
                        //Agregamos un valor a la variable
                        conPer++;
                    }
                    //VISIBLE - se muestra
                    //INVISIBLE no se muestra, pero abarca un espacio en pantalla
                    //GONE - no se muestra y no abarca un espacio en pantalla
                    //VISIBLE - INVISIBLE - GONE
                    //Hacemos que el boton de VerTodo no se muestre
                    btnVerTodo.setVisibility(View.GONE);
                    //Cambiar el nombre del boton
                    btnRegistro.setText("Modificar");
                    //Almacenar la posición o identificar en el boton
                    btnRegistro.setTag(posicion);

                } else {
                    Toast.makeText(this,
                            "No se pudo obtener datos", Toast.LENGTH_SHORT).show();
                    //Sirve para poder cerrar la pantalla que estás visualizando actualmente
                    finish();
                }
            }
        }/* else {
            Toast.makeText(this, "No se pudo obtener datos", Toast.LENGTH_SHORT).show();
            finish();
        }*/


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

                int valor = (int) btnRegistro.getTag();
                if (valor == -1) {
                    //Agregamos una noticia al listado
                    listaNoticias.add(noticia);

                    //Mostramos un mensaje de confirmación
                    Toast.makeText(MainActivity.this, "Se registro", Toast.LENGTH_SHORT).show();
                } else {
                    //listaNoticias.get(valor) - obteniendo el dato actual de la noticia
                    listaNoticias.get(valor).setPeriodico(periodico);
                    listaNoticias.get(valor).setCategoria(categira);
                    listaNoticias.get(valor).setTitulo(titulo);
                    listaNoticias.get(valor).setAprobado(aprobado);

                    Toast.makeText(MainActivity.this, "Se actualizo", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        btnVerTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Indicamos en que pantalla nos ubicamos y a que pantalla nos dirigimos
                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                //Ejecutamos la acción a realizar
                startActivity(intent);
            }
        });
    }
}
