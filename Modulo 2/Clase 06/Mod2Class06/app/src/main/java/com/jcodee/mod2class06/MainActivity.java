package com.jcodee.mod2class06;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment)
                getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                LatLng latLng1 = new LatLng(-31.4735863, -70.734234);
                LatLng latLng2 = new LatLng(-32.4735863, -71.734234);
                LatLng latLng3 = new LatLng(-29.4735863, -50.734234);

                googleMap.addMarker(
                        new MarkerOptions()
                                .position(latLng1)
                                .title("Titulo")
                                .snippet("Descripción")
                );
                googleMap.addMarker(
                        new MarkerOptions()
                                .position(latLng2)
                                .title("Titulo")
                                .snippet("Descripción")
                );
                googleMap.addMarker(
                        new MarkerOptions()
                                .position(latLng3)
                                .title("Titulo")
                                .snippet("Descripción")
                );

                //Creamos una línea entre los puntos
                googleMap.addPolyline(new PolylineOptions()
                        //Se agregan todas las ubicaciones
                        .add(latLng1, latLng2, latLng3))
                        //Cambiamos el color de la línea que se pinta
                        .setColor(Color.RED);

                googleMap.addCircle(new CircleOptions()
                        .center(latLng1)
                        .visible(true)
                        .radius(1000)
                        .strokeColor(Color.GREEN));

                googleMap.addPolygon(new PolygonOptions()
                        .add(latLng1, latLng2, latLng3))
                        .setFillColor(Color.BLUE);

                googleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(latLng2, 15));
            }
        });

    }
}
