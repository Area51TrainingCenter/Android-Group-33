package com.johannfjs.mod1class8.fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod1class8.DetalleActivity;
import com.johannfjs.mod1class8.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagenFragment extends Fragment {
    private SimpleDraweeView sdvImagen;

    public ImagenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imagen, container, false);
        sdvImagen = (SimpleDraweeView) view.findViewById(R.id.sdvImagen);

        if (getArguments() != null) {
            if (getArguments().containsKey("posicion")) {
                int posicion = getArguments().getInt("posicion");
                sdvImagen.setImageURI(Uri.parse(DetalleActivity.rutas.get(posicion)));
            }
        }

        return view;
    }

}
