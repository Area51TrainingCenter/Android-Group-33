package com.jcodee.mod2class7.database;

import com.jcodee.mod2class7.entidades.Productos;
import com.jcodee.mod2class7.entidades.Usuario;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 15/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class MetodosRealm {
    public static void registrarPersona(Usuario usuario) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(usuario);
        realm.commitTransaction();
    }


    public static Usuario validarUsuario(String usuario, String contrasenia) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Usuario.class)
                .equalTo("usuario", usuario)
                .equalTo("contrasenia", contrasenia)
                .findFirst();
    }

    public static int nextId() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(Usuario.class).max("id");
        return number != null ? number.intValue() + 1 : 1;
    }

    public static void registrarProducto(Productos productos) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(productos);
        realm.commitTransaction();
    }

    public static RealmResults<Productos> obtenerProductos(int idUsuario) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Productos.class)
                .equalTo("idUsuario", idUsuario)
                .findAll();
    }

    public static int nextProductoId() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(Productos.class).max("id");
        return number != null ? number.intValue() + 1 : 1;
    }
}
