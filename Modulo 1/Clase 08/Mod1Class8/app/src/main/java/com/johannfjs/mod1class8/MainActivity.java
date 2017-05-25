package com.johannfjs.mod1class8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.johannfjs.mod1class8.adapters.ProductoAdapter;
import com.johannfjs.mod1class8.modelos.ProductoModelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ProductoModelo> lista = new ArrayList<>();
    private ListView lvLista;
    private ProductoAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new ProductoAdapter(MainActivity.this, lista);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView) findViewById(R.id.lvLista);


        ProductoModelo productoModelo = new ProductoModelo();
        productoModelo.setId(lista.size() + 1);
        productoModelo.setTitulo("Lapicero");
        productoModelo.setDescripcion("Lapicero Pilot");
        productoModelo.setCelular("998877665");
        productoModelo.setPrecio(10.2);
        ArrayList<String> imagenes = new ArrayList<>();
        imagenes.add("http://concepto.de/wp-content/uploads/2015/03/Paisaje.jpg");
        imagenes.add("https://1.bp.blogspot.com/-JREhSKN8sMM/VmH2B-jmFXI/AAAAAAAAIzg/ScNtA185M88/s1600/02273%2Bpaisajes01.jpg");
        productoModelo.setFotos(imagenes);
        lista.add(productoModelo);


        ProductoModelo productoModelo1 = new ProductoModelo();
        productoModelo1.setId(lista.size() + 1);
        productoModelo1.setTitulo("Lapicero de Marca");
        productoModelo1.setDescripcion("Lapicero de Marca super bueno");
        productoModelo1.setCelular("998765432");
        productoModelo1.setPrecio(20.0);
        ArrayList<String> imagenes1 = new ArrayList<>();
        imagenes1.add("res:/" + R.drawable.image1);
        imagenes1.add("res:/" + R.drawable.image2);
        productoModelo1.setFotos(imagenes1);
        lista.add(productoModelo1);
    }
}
