package com.jcodee.mod3class1.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jcodee.mod3class1.R;
import com.jcodee.mod3class1.WebsiteActivity;
import com.jcodee.mod3class1.rest.response.UsuarioResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DatoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<UsuarioResponse> lista;

    public DatoAdapter(Context context, ArrayList<UsuarioResponse> lista) {
        this.context = context;
        this.lista = lista;
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvUsuario)
        TextView tvUsuario;
        @BindView(R.id.btnCorreo)
        ImageButton btnCorreo;
        @BindView(R.id.btnWebsite)
        ImageButton btnWebsite;

        public UsuarioViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dato, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UsuarioViewHolder usuarioViewHolder = (UsuarioViewHolder) holder;
        if (usuarioViewHolder != null) {
            final UsuarioResponse usuarioResponse = lista.get(position);
            usuarioViewHolder.tvNombre.setText(usuarioResponse.getName());
            usuarioViewHolder.tvUsuario.setText(usuarioResponse.getUsername());
            usuarioViewHolder.btnCorreo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + usuarioResponse.getEmail()));
                    context.startActivity(intent);

                }
            });
            usuarioViewHolder.btnWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebsiteActivity.class);
                    intent.putExtra("url", usuarioResponse.getWebsite());
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
