package com.johannfjs.mod1class8.modelos;

import java.util.ArrayList;

/**
 * Created by johannfjs on 18/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ProductoModelo {
    private int id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String celular;
    private ArrayList<String> fotos;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<String> fotos) {
        this.fotos = fotos;
    }
}
