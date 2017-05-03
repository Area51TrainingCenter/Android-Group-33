package com.jcodee.mod1class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    /*
    * Ciclo de vida de un activity
    * - onCreate = al momento que seleccionamos el icono de la aplicación
    * - onStart = es el proceso de cargar la aplicación (pantalla en blanco por tiempo breve)
    * - onResume = se ejecuta cuando nosotros ya podemos visualizar la aplicación en pantalla
    * - onPause = pausa la pantalla o actividad y se ejecuta cuando se detiene o se retrocede
    * - onStop = detiene la pantalla o actividad
    * - onRestart = se ejecuta al regresar a la pantalla
    * - onDestroy = se ejecuta cuando la pantalla deja de existir en el historial de pantallas
    */

    //Creamos las variables
    private EditText textoUno, textoDos;
    private Button procesar, siguiente;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //añadir y leer el archivo xml o diseño
        setContentView(R.layout.activity_home);

        //Método que sirve para imprimir en la consola de Android
        Log.d("Resultado", "onCreate");

        //Vinculamos las variables con los componentes que tenemos en el diseño
        textoUno = (EditText) findViewById(R.id.etTextoUno);
        textoDos = (EditText) findViewById(R.id.etTextoDos);
        procesar = (Button) findViewById(R.id.btnProcesar);
        texto = (TextView) findViewById(R.id.tvTexto);
        siguiente = (Button) findViewById(R.id.btnSiguiente);

        //Cargamos un valor al editText
        textoUno.setText("Hola desde Java");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Resultado", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resultado", "onResume");

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pasar del HomeActivity al DetalleActivity
                Intent intent = new Intent(HomeActivity.this, DetalleActivity.class);

                //Agregamos el dato para poder pasarlo a la siguiente pantalla
                intent.putExtra("abc", texto.getText().toString());

                //Ejecutamos la acción a realizar (a través del intent)
                startActivity(intent);

            }
        });

        //Creamos un evento onClick a nuestro boton procesar
        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //v.getId()==textoUno.getId()
                //Aquí se realiza las acciones a realizar
                String valorUno = textoUno.getText().toString();
                String valorDos = textoDos.getText().toString();

                //Validams que el campo de TextUno tenga datos
                if (valorUno.isEmpty()) {
                    //Si es que no hay datos, mostramos un mensaje de error
                    textoUno.setError("Valor requerido");
                    //Al poner return aquí, evitas que pase a las siguientes líneas de código
                    return;
                } else {
                    //Si en caso todo está ok, eliminamos el mensaje de error si es que hubiese
                    textoUno.setError(null);
                }

                if (valorDos.isEmpty()) {
                    textoDos.setError("Valor requerido");
                    return;
                } else {
                    textoDos.setError(null);
                }

                //Concatenamos los dos textos para convertirlo en uno solo
                //HTML fromHtml el valor que se encuentre dentro va a poderse interpretar como
                //una etiqueta de html y se mostrará en la pantalla
                String valorTexto = valorUno + " " +
                        Html.fromHtml("<b>" + valorDos + "</b>");
                //Seteamos el valor del TextView para poder mostrar el valor concatenado
                texto.setText(valorTexto);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Resultado", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Resultado", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Resultado", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Resultado", "onRestart");
    }
}
