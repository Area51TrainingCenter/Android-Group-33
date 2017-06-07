package com.johannfjs.mod2class03.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod2class03.R;
import com.johannfjs.mod2class03.modelos.Persona;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 1/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PersonaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Persona> lista;

    public PersonaAdapter(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.lista = lista;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvApellido)
        TextView tvApellido;
        @BindView(R.id.cardView)
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //Asociamos el diseño a utilizar
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    //Cambiar los datos a mostrar en el diseño
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Persona persona = lista.get(position);

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Random random = new Random();
        myViewHolder.tvNombre.setText(persona.getNombre() + " " + random.nextInt(10));
        myViewHolder.tvApellido.setText(persona.getApellido());
        myViewHolder.sdvImagen.setImageURI(Uri.parse("http://www.cnnchile.com/sites/default/files/avatar.jpg"));

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Hola: " + persona.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    //Cantidad de elementos a iterar
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
