package com.jcodee.mod1class6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onResume() {
        super.onResume();

        //Creamos el evento click para cada elemento del GridView
        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Detallamos la acción a realizar
                Intent intent = new Intent(GaleriaActivity.this, DetalleActivity.class);
                intent.putExtra("posicion", position);
                startActivity(intent);

            }
        });
    }
}
