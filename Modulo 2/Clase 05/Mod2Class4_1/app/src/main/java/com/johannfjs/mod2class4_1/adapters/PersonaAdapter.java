package com.johannfjs.mod2class4_1.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.johannfjs.mod2class4_1.DetalleActivity;
import com.johannfjs.mod2class4_1.R;
import com.johannfjs.mod2class4_1.entidad.PersonaEntidad;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 6/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PersonaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private RealmResults<PersonaEntidad> lista;

    public PersonaAdapter(Context context, RealmResults<PersonaEntidad> lista) {
        this.context = context;
        this.lista = lista;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.etNombreCompleto)
        TextView etNombreCompleto;
        @BindView(R.id.btnLlamar)
        Button btnLlamar;
        @BindView(R.id.btnVerMapa)
        Button btnVerMapa;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        if (myViewHolder != null) {
            final PersonaEntidad personaEntidad = lista.get(position);
            myViewHolder.etNombreCompleto.setText(personaEntidad.getNombre());
            myViewHolder.btnLlamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("tel:/" + personaEntidad.getNumero());
                    context.startActivity(intent);
                }
            });
            myViewHolder.btnVerMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetalleActivity.class);
                    intent.putExtra("direccion", personaEntidad.getDireccion());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
