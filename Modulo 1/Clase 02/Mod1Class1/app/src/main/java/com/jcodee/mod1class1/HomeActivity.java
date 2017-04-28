package com.jcodee.mod1class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //añadir y leer el archivo xml o diseño
        setContentView(R.layout.activity_home);

        Log.d("Resultado", "onCreate");

        //Vinculamos las variables con los componentes que tenemos en el diseño
        textoUno = (EditText) findViewById(R.id.etTextoUno);

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
