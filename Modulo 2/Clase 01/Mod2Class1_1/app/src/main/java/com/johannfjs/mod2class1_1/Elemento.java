package com.johannfjs.mod2class1_1;

/**
 * Created by johannfjs on 25/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Elemento {
    private int id;
    private int idTema;
    private String tema;
    private String titulo;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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
