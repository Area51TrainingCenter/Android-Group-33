package com.johannfjs.mod2class4_1;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class DetalleActivity extends AppCompatActivity {
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        //no se llama así -> mapFragment=(MapFragment) findViewById(R.id.map);
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        //Cargamos el contenido del mapa
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                //Obtener la dirección
                if (getIntent() != null) {
                    if (getIntent().hasExtra("direccion")) {
                        //Obtenemos la dirección
                        String direccion = getIntent().getStringExtra("direccion");

                        //Buscar la latitud y longitud referente a la dirección ingresada
                        Geocoder geocoder = new Geocoder(DetalleActivity.this);
                        try {
                            //Buscamos la ubicación de la dirección que hemos ingresado (solo obtenemos
                            // un resultado)
                            List<Address> direcciones = geocoder.getFromLocationName(direccion, 1);

                            //Obtenemos el primer resulado para poder sacar la información
                            Address dato = direcciones.get(0);

                            //Obtenemos la latitud y longitud
                            double latitud = dato.getLatitude();
                            double longitud = dato.getLongitude();

                            //Creamos un punto en el mapa (o un pin)
                            googleMap.addMarker(
                                    new MarkerOptions().title("Titulo")
                                            .snippet("Descripción")
                                            .position(new LatLng(latitud, longitud))
                            );
                            //Mover el mapa hacia el punto que se ha creado
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(latitud, longitud),
                                    14
                            ));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        });
    }
}
