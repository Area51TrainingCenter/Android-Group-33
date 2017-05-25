package com.johannfjs.mod1class8.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.johannfjs.mod1class8.DetalleActivity;
import com.johannfjs.mod1class8.fragmentos.ImagenFragment;

/**
 * Created by johannfjs on 18/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ImagenAdapter extends FragmentStatePagerAdapter {
    public ImagenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ImagenFragment imagenFragment = new ImagenFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("posicion", position);
        imagenFragment.setArguments(bundle);
        return imagenFragment;
    }

    @Override
    public int getCount() {
        return DetalleActivity.rutas.size();
    }
}
