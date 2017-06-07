package com.johannfjs.mod2class03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.johannfjs.mod2class03.adapters.PersonaAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends AppCompatActivity {

    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        PersonaAdapter adapter =
                new PersonaAdapter(ListadoActivity.this, MainActivity.listaPersonas);
        rvDatos.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
        rvDatos.setAdapter(adapter);
    }
}
