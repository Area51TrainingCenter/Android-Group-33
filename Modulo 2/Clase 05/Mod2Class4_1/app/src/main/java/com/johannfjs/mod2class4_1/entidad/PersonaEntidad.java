package com.johannfjs.mod2class4_1.entidad;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johannfjs on 6/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PersonaEntidad extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;
    private String apellido;
    private String numero;
    private String direccion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
