package com.jcodee.mod1class6.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod1class6.R;
import com.jcodee.mod1class6.modelos.Galeria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 11/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaAdapter extends ArrayAdapter<Galeria> {
    //Declaramos una variable de tipo contexto
    private Context context;
    //Declaramos una variable de tipo lista de objeto que se manejara para la grilla
    private ArrayList<Galeria> lista;

    public GaleriaAdapter(@NonNull Context context, @NonNull ArrayList<Galeria> objects) {
        super(context, 0, objects);
        //Seteamos los valores de las variables por lo que se trae en el constructor
        this.context = context;
        this.lista = objects;
    }

    //Método donde se carga el diseño y se setea los datos
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Indicamos con que diseño se realizará
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);

        //Creamos las variables para hacer referencia a los componentes
        SimpleDraweeView sdvImagen =
                (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
        TextView tvTexto = (TextView) convertView.findViewById(R.id.tvTexto);

        //Obtenemos el objeto del listado según la posición
        Galeria galeria = lista.get(position);

        //Seteamos los datos
        tvTexto.setText(galeria.getTitulo());
        sdvImagen.setImageURI(Uri.parse(galeria.getRutaImagen()));

        return convertView;
    }
}
