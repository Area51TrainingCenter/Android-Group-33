package com.jcodee.mod1class4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodee.mod1class4.R;
import com.jcodee.mod1class4.modelos.Noticia;

import java.util.ArrayList;

/**
 * Created by johannfjs on 4/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class NoticiaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Noticia> lista;

    public NoticiaAdapter(Context context, ArrayList<Noticia> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Cantidad de elementos que va a tener el listado
    @Override
    public int getCount() {
        return lista.size();
    }

    //Para obtener un objeto según la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Para obtener un identificador según la posición
    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    //Indicamos que diseño es el que se tendrá o se manejara y también donde
    //vamos a setear los datos a mostrar en nuestro diseño
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Definir el diseño que vamos a emplear
        convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        TextView tvPeriodico = (TextView) convertView.findViewById(R.id.tvPeriodico);
        TextView tvCategoria = (TextView) convertView.findViewById(R.id.tvCategoria);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        ImageView ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);

        Noticia noticia = (Noticia) getItem(position);
        tvPeriodico.setText(noticia.getPeriodico());
        tvCategoria.setText(noticia.getCategoria());
        tvTitulo.setText(noticia.getTitulo());

        if (noticia.isAprobado()) {
            ivImagen.setImageResource(R.drawable.check);
        } else {
            ivImagen.setImageResource(R.drawable.cross);
        }

        return convertView;
    }
}
