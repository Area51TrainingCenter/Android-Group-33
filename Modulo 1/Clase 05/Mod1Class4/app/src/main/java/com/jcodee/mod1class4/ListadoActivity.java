package com.jcodee.mod1class4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodee.mod1class4.adapters.NoticiaAdapter;

/**
 * Created by johannfjs on 4/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ListadoActivity extends AppCompatActivity {
    private NoticiaAdapter adapter;
    private ListView lvLista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvLista = (ListView) findViewById(R.id.lvLista);

        adapter = new NoticiaAdapter(ListadoActivity.this, MainActivity.listaNoticias);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Realizar la acción de onClick al listado por cada item
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //Este método se ejecuta al momento que seleccionamos un item de la lista
                AlertDialog.Builder builder = new AlertDialog.Builder(ListadoActivity.this);
                //Cambiamos el titulo del alert dialog
                builder.setTitle("Opciones");
                //Cambiamos el contenido del mensaje
                builder.setMessage("Seleccione Opción");
                //Opciones del dialogo predefinidas: POSITIVE - NEGATIVE - NEUTRAL

                //Creamos el evento click para la opción Modificar
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(ListadoActivity.this, MainActivity.class);
                        intent.putExtra("posicion", position);
                        startActivity(intent);

                    }
                });
                //Creamos el evento click para la opción Eliminar
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        MainActivity.listaNoticias.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(ListadoActivity.this,
                                "Se elimino el registro", Toast.LENGTH_SHORT).show();

                    }
                });
                //builder.setNeutralButton("")

                //Si no se pone está línea el alertDialog no se podrá visualizar
                //*Con está línea se construye el componente
                builder.create().show();

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        adapter.notifyDataSetChanged();
    }
}
