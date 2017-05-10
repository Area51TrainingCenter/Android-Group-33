package com.jcodee.mod1class4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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
}
