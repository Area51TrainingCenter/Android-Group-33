package com.jcodee.mod3class2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spUsuarios)
    Spinner spUsuarios;
    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etCuerpo)
    EditText etCuerpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnGuardar)
    public void onViewClicked() {
        String usuario = spUsuarios.getSelectedItem().toString();
        String titulo = etTitulo.getText().toString();
        String cuerpo = etCuerpo.getText().toString();

        if (titulo.isEmpty()) {
            etTitulo.setError("El campo es requerido");
            return;
        }
        if (cuerpo.isEmpty()) {
            etCuerpo.setError("El campo es requerido");
            return;
        }

        
    }
}
