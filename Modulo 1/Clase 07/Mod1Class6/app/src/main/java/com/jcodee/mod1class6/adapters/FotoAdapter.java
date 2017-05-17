package com.jcodee.mod1class6.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jcodee.mod1class6.MainActivity;
import com.jcodee.mod1class6.fragmentos.FotoFragment;

/**
 * Created by johannfjs on 16/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class FotoAdapter extends FragmentStatePagerAdapter {
    public FotoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Creamos un fragmento
        FotoFragment fragment = new FotoFragment();
        //Creamos la variable Bundle por la cual vamos a poder pasar información
        Bundle bundle = new Bundle();
        //Agregamos la informaión que vamos a enviar
        bundle.putInt("posicion", position);
        //Agregamos el bundle con los parametros a nuestro fragmento
        fragment.setArguments(bundle);
        //Devolvemos el fragmento creado con la información
        return fragment;
    }

    @Override
    public int getCount() {
        //Cantidad de fotos
        return MainActivity.listaFotos.size();
    }
}
