package com.johannfjs.mod2class1_1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod2class1_1.R;
import com.johannfjs.mod2class1_1.modelos.Elemento;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 30/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ElementoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Elemento> lista;

    public ElementoAdapter(Context context, ArrayList<Elemento> lista) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item, parent, false);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        Elemento item = (Elemento) getItem(position);

        viewHolder.tvTema.setText("Tema: " + item.getTema());
        viewHolder.tvTitulo.setText("Titulo: " + item.getTitulo());
        viewHolder.tvDescripcion.setText("Descripción: " + item.getDescripcion());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvTema)
        TextView tvTema;
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;
        @BindView(R.id.tvDescripcion)
        TextView tvDescripcion;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
