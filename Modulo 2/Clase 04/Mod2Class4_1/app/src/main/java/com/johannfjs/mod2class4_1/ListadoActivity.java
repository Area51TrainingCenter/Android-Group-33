package com.johannfjs.mod2class4_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.johannfjs.mod2class4_1.adapters.PersonaAdapter;
import com.johannfjs.mod2class4_1.database.SentenciaSQL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListadoActivity extends AppCompatActivity {

    @BindView(R.id.etBuscar)
    EditText etBuscar;
    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);

        SentenciaSQL sentenciaSQL = new SentenciaSQL();
        PersonaAdapter personaAdapter = new PersonaAdapter(ListadoActivity.this,
                sentenciaSQL.obtenerPersonas());
        rvDatos.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
        rvDatos.setAdapter(personaAdapter);
    }

    @OnClick(R.id.btnBuscar)
    public void onViewClicked() {
    }
}
