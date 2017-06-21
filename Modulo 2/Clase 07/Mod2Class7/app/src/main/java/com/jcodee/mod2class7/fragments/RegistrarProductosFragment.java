package com.jcodee.mod2class7.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodee.mod2class7.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrarProductosFragment extends Fragment {


    public RegistrarProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrar_productos, container, false);
    }

}
