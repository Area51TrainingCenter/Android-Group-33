package com.jcodee.mod1class6.fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod1class6.MainActivity;
import com.jcodee.mod1class6.R;
import com.jcodee.mod1class6.modelos.Galeria;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private SimpleDraweeView sdvImagen;
    private TextView tvTitulo;
    private TextView tvDescripcion;

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);

        sdvImagen = (SimpleDraweeView) view.findViewById(R.id.sdvImagen);
        tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
        tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        //Obtenemos los datos que se han enviado a través del bundle
        Bundle bundle = getArguments();
        //Verificamos que haya traido información
        if (bundle != null) {
            //Verificamos si dentro del bundle se ha traido la etiqueta posicion
            if (bundle.containsKey("posicion")) {
                //Obtenemos la posición
                int posicion = bundle.getInt("posicion");

                //Obtenemos el objeto de la lista según la posición que se ha enviado
                Galeria galeria = MainActivity.listaFotos.get(posicion);
                //Validamos que la galeria tenga datos
                if (galeria != null) {

                    //Seteamos los valores para que se pueda mostrar
                    sdvImagen.setImageURI(Uri.parse(galeria.getRutaImagen()));
                    tvTitulo.setText(galeria.getTitulo());
                    tvDescripcion.setText(galeria.getDescripcion());

                }
            }
        }

    }
}
