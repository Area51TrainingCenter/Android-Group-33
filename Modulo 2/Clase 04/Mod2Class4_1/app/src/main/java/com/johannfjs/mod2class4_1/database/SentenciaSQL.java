package com.johannfjs.mod2class4_1.database;

import com.johannfjs.mod2class4_1.entidad.PersonaEntidad;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 6/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {

    public void insertar(PersonaEntidad personaEntidad) {
        //Obtenemos la configuración para la conexión a la base de datos
        Realm realm = Realm.getDefaultInstance();
        //Iniciamos una transacción
        realm.beginTransaction();
        //Registramos en la base de datos
        realm.copyToRealm(personaEntidad);
        //Grabamos en la base de datos
        realm.commitTransaction();
    }

    public int obtenerSiguienteId() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(PersonaEntidad.class).max("id");
        int resultado = 0;
        if (number != null) {
            resultado = number.intValue() + 1;
        } else {
            resultado = 1;
        }
        return resultado;//(number != null ? number.intValue() + 1 : 1);
    }

    public RealmResults<PersonaEntidad> obtenerPersonas() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(PersonaEntidad.class).findAll();
    }
}
