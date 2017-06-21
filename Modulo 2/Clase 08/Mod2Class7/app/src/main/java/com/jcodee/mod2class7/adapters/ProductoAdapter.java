package com.jcodee.mod2class7.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodee.mod2class7.R;
import com.jcodee.mod2class7.entidades.Productos;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 20/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ProductoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private RealmResults<Productos> lista;

    public ProductoAdapter(Context context, RealmResults<Productos> lista) {
        this.context = context;
        this.lista = lista;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;
        @BindView(R.id.tvDescripcion)
        TextView tvDescripcion;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        if (myViewHolder != null) {
            Productos productos = lista.get(position);
            myViewHolder.tvTitulo.setText(productos.getTitulo());
            myViewHolder.tvDescripcion.setText(productos.getDescripcion());
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
