package com.jcodee.mod1class6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.jcodee.mod1class6.adapters.GaleriaAdapter;

public class GaleriaActivity extends AppCompatActivity {
    private GridView gvDatos;
    private GaleriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        gvDatos = (GridView) findViewById(R.id.gvDatos);

        adapter = new GaleriaAdapter(GaleriaActivity.this, MainActivity.listaFotos);
        gvDatos.setAdapter(adapter);

    }
}
