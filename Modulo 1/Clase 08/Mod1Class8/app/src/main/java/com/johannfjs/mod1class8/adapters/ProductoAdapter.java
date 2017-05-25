package com.johannfjs.mod1class8.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod1class8.R;
import com.johannfjs.mod1class8.modelos.ProductoModelo;

import java.util.ArrayList;

/**
 * Created by johannfjs on 18/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ProductoModelo> lista;

    public ProductoAdapter(Context context, ArrayList<ProductoModelo> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        SimpleDraweeView sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        TextView tvDescripcion = (TextView) convertView.findViewById(R.id.tvDescripcion);
        TextView tvPrecio = (TextView) convertView.findViewById(R.id.tvPrecio);

        ProductoModelo productoModelo = (ProductoModelo) getItem(position);
        tvTitulo.setText(productoModelo.getTitulo());
        tvDescripcion.setText(productoModelo.getDescripcion());
        tvPrecio.setText(String.valueOf(productoModelo.getPrecio()));
        if (productoModelo.getFotos().size() > 0) {
            sdvImagen.setImageURI(Uri.parse(productoModelo.getFotos().get(0)));
        }

        return convertView;
    }
}
