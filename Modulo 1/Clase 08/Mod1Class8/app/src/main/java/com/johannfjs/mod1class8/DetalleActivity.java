package com.johannfjs.mod1class8;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.johannfjs.mod1class8.adapters.ImagenAdapter;
import com.johannfjs.mod1class8.modelos.ProductoModelo;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView tvTitulo, tvPrecio, tvDescripcion;
    private Button btnLlamar;
    public static ArrayList<String> rutas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvPrecio = (TextView) findViewById(R.id.tvPrecio);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);

        if (getIntent() != null) {
            if (getIntent().hasExtra("posicion")) {
                int posicion = getIntent().getIntExtra("posicion", -1);
                ProductoModelo productoModelo = MainActivity.lista.get(posicion);
                rutas = productoModelo.getFotos();

                ImagenAdapter imagenAdapter=new ImagenAdapter(getSupportFragmentManager());
                viewPager.setAdapter(imagenAdapter);
            }
        }
    }
}
