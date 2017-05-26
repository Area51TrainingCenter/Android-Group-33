package com.johannfjs.mod2class1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.johannfjs.mod2class1_1.sqlite.SentenciaSQL;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends AppCompatActivity {

    @BindView(R.id.tvTexto)
    TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL(ListadoActivity.this);
        ArrayList<Elemento> lista = sentenciaSQL.obtenerElementos();

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
    }
}
