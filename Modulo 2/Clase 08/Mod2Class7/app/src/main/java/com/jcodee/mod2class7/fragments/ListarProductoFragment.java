package com.jcodee.mod2class7.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodee.mod2class7.R;
import com.jcodee.mod2class7.adapters.ProductoAdapter;
import com.jcodee.mod2class7.database.MetodosRealm;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarProductoFragment extends Fragment {


    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;
    Unbinder unbinder;

    public ListarProductoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_producto, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


        SharedPreferences sharedPreferences =
                getActivity().getSharedPreferences("class7", Context.MODE_PRIVATE);
        ProductoAdapter productoAdapter =
                new ProductoAdapter(getActivity(), MetodosRealm.obtenerProductos(
                        sharedPreferences.getInt("idUsuario", 0)
                ));
        rvDatos.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDatos.setAdapter(productoAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
