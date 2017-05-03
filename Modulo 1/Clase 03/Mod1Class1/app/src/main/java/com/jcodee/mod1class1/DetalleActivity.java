package com.jcodee.mod1class1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by johannfjs on 2/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleActivity extends AppCompatActivity {

    private TextView ingresarTexto;
    private EditText texto;
    private TextView resultado;
    private Button atras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ingresarTexto = (TextView) findViewById(R.id.tvTexto);
        texto = (EditText) findViewById(R.id.etTexto);
        resultado = (TextView) findViewById(R.id.tvTextoResultado);
        atras = (Button) findViewById(R.id.btnAtras);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Preguntamos si el intent trae datos
        if (getIntent() != null) {
            //Preguntamos si el intent trae la llave "abc"
            if (getIntent().hasExtra("abc")) {
                //Obtener el valor de la llave abc
                String abc = getIntent().getStringExtra("abc");
                //etTexto.addTextChangeListener(new TextWatcher())
                //Seteamos el valor que se trae desde la pantalla 1
                ingresarTexto.setText(abc);
            }
        }

        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String valor = texto.getText().toString();
                resultado.setText(valor);
                //ListView
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cierra una pantalla o una actividad
                finish();

            }
        });
    }
}
