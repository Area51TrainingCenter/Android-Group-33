package com.johannfjs.mod2class1_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.johannfjs.mod2class1_1.adapters.ElementoAdapter;
import com.johannfjs.mod2class1_1.modelos.Elemento;
import com.johannfjs.mod2class1_1.sqlite.SentenciaSQL;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends AppCompatActivity {

    /*
        @BindView(R.id.tvTexto)
        TextView tvTexto;
    */
    @BindView(R.id.lvLista)
    ListView lvLista;

    private ElementoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final SentenciaSQL sentenciaSQL = new SentenciaSQL(ListadoActivity.this);
        final ArrayList<Elemento> lista = sentenciaSQL.obtenerElementos();
        adapter = new ElementoAdapter(ListadoActivity.this, lista);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Elemento elemento = lista.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ListadoActivity.this);
                builder.setTitle("Seleccione");
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {

                        final Dialog dialog1 = new Dialog(ListadoActivity.this);
                        dialog1.setContentView(R.layout.item_modificar);

                        final Spinner spTema = (Spinner) dialog1.findViewById(R.id.spTema);
                        final EditText etTitulo = (EditText) dialog1.findViewById(R.id.etTitulo);
                        final EditText etDescripcion = (EditText) dialog1.findViewById(R.id.etDescripcion);
                        Button btnGuardar = (Button) dialog1.findViewById(R.id.btnGuardar);

                        ArrayList<String> lista = sentenciaSQL.obtenerTemas();
                        ArrayAdapter arrayAdapter = new ArrayAdapter(ListadoActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                lista);
                        spTema.setAdapter(arrayAdapter);

                        etTitulo.setText(elemento.getTitulo());
                        etDescripcion.setText(elemento.getDescripcion());
                        int i = 0;
                        for (String tema : lista) {
                            if (tema.equals(elemento.getTema())) {
                                spTema.setSelection(i);
                                break;
                            }
                            i++;
                        }

                        btnGuardar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Elemento elementoActualizar = new Elemento();
                                elementoActualizar.setId(elemento.getId());
                                int idTema = sentenciaSQL.obtenerTemas(spTema.getSelectedItem().toString());
                                elementoActualizar.setIdTema(idTema);
                                elementoActualizar.setDescripcion(etDescripcion.getText().toString());
                                elementoActualizar.setTitulo(etTitulo.getText().toString());

                                sentenciaSQL.actualizarElemento(elementoActualizar);
                                //adapter.notifyDataSetChanged();
                                ArrayList<Elemento> lista = sentenciaSQL.obtenerElementos();
                                adapter = new ElementoAdapter(ListadoActivity.this, lista);
                                lvLista.setAdapter(adapter);
                                dialog1.dismiss();

                            }
                        });

                        dialog1.show();

                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sentenciaSQL.eliminarElemento(elemento.getId());
                        //adapter.notifyDataSetChanged();
                        ArrayList<Elemento> lista = sentenciaSQL.obtenerElementos();
                        adapter = new ElementoAdapter(ListadoActivity.this, lista);
                        lvLista.setAdapter(adapter);

                    }
                });
                builder.show();

            }
        });

/*
        StringBuilder stringBuilder = new StringBuilder();
        for (Elemento item : lista) {
            stringBuilder.append("Titulo->");
            stringBuilder.append(item.getTitulo());
            stringBuilder.append("\n");
            stringBuilder.append("Descripción->");
            stringBuilder.append(item.getDescripcion());
            stringBuilder.append("\n------------");
        }
        tvTexto.setText(stringBuilder.toString());
        */
    }
}
