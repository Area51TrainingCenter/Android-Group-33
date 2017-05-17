package com.jcodee.mod1class6;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcodee.mod1class6.adapters.FotoAdapter;
import com.jcodee.mod1class6.views.ZoomOutPageTransformer;

public class DetalleActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    @Override
    protected void onResume() {
        super.onResume();

        FotoAdapter fotoAdapter = new FotoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fotoAdapter);
        viewPager.setPageTransformer(false, new ZoomOutPageTransformer());

        //Validamos que se esten obteniendo registros en el intent
        if (getIntent() != null) {
            //Validamos que haya la llave de posicion
            if (getIntent().hasExtra("posicion")) {
                //Obtenemos el valor de la posición
                int posicion = getIntent().getIntExtra("posicion", -1);
                //Hacemos que al momento de cargar el viewPager el fragmento que se muestre
                //sea el que hemos seleccionado
                viewPager.setCurrentItem(posicion);
            }
        }

    }
}
