package com.jcodee.mod3class8.modelos;

import java.util.ArrayList;

/**
 * Created by johannfjs on 20/07/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990 870 011
 */

public class Preguntas {
    private int id;
    private String descripcion;
    private ArrayList<Alternativas> alternativas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Alternativas> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<Alternativas> alternativas) {
        this.alternativas = alternativas;
    }
}
