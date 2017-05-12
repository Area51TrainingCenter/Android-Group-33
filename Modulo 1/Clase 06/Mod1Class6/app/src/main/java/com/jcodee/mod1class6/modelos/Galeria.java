package com.jcodee.mod1class6.modelos;

/**
 * Created by johannfjs on 11/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Galeria {
    private int id;
    private String titulo;
    private String descripcion;
    private String rutaImagen;

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
