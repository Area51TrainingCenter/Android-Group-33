package com.jcodee.mod2class7.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class7.R;
import com.jcodee.mod2class7.database.MetodosRealm;
import com.jcodee.mod2class7.entidades.Productos;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrarProductosFragment extends Fragment {


    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etDescripcion)
    EditText etDescripcion;
    Unbinder unbinder;

    public RegistrarProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registrar_productos, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnGuardar)
    public void onViewClicked() {

        String titulo = etTitulo.getText().toString();
        String descripcion = etDescripcion.getText().toString();

        Productos productos = new Productos();
        productos.setId(MetodosRealm.nextProductoId());


        SharedPreferences sharedPreferences =
                getActivity().getSharedPreferences("class7", Context.MODE_PRIVATE);

        productos.setIdUsuario(sharedPreferences.getInt("idUsuario", 0));
        productos.setTitulo(titulo);
        productos.setDescripcion(descripcion);
        MetodosRealm.registrarProducto(productos);
        Toast.makeText(getActivity(),
                "Se registro correctamente", Toast.LENGTH_SHORT).show();

    }
}
