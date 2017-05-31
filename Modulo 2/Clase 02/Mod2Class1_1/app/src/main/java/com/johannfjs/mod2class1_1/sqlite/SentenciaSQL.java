package com.johannfjs.mod2class1_1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.mod2class1_1.modelos.Elemento;

import java.util.ArrayList;

/**
 * Created by johannfjs on 25/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    private ManageOpenHelper conexion;

    public SentenciaSQL(Context context) {
        conexion = new ManageOpenHelper(context);
    }

    public void insertarElemento(int idTema, String titulo, String descripcion) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id_tema", idTema);
        contentValues.put("titulo", titulo);
        contentValues.put("descripcion", descripcion);

        db.insert("tb_elemento", null, contentValues);
    }

    public ArrayList<Elemento> obtenerElementos() {
        //Habilitamos el acceso de solo lectura a nuestra base de datos
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Realizamos el query a consultar y retornamos el dato en un cursor
        Cursor cursor = db.rawQuery("" +
                "select a.id as id," +
                "a.titulo as titulo," +
                "b.descripcion as tema," +
                "a.descripcion as descripcion " +
                "from tb_elemento a " +
                "inner join tb_tema b on a.id_tema=b.id" +
                "", null);

        ArrayList<Elemento> lista = new ArrayList<>();

        //Verificamos que haya al menos un dato
        if (cursor.moveToFirst()) {
            //Recorremos los datos que hay y los obtenemos a través del nombre de la columna
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                String tema = cursor.getString(cursor.getColumnIndex("tema"));
                String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));

                Elemento elemento = new Elemento();
                elemento.setId(id);
                elemento.setTitulo(titulo);
                elemento.setTema(tema);
                elemento.setDescripcion(descripcion);
                lista.add(elemento);

            } while (cursor.moveToNext());
        }
        return lista;
    }

    public ArrayList<String> obtenerTemas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_tema", null);
        ArrayList<String> lista = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(cursor.getColumnIndex("descripcion")));
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public int obtenerTemas(String descripcion) {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from tb_tema where descripcion='" + descripcion + "'", null);
        int resultado = 0;
        if (cursor.moveToFirst()) {
            do {
                resultado = cursor.getInt(cursor.getColumnIndex("id"));
            } while (cursor.moveToNext());
        }
        return resultado;
    }

    public void actualizarElemento(Elemento elemento) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", elemento.getTitulo());
        contentValues.put("descripcion", elemento.getDescripcion());
        contentValues.put("id_tema", elemento.getIdTema());

        db.update("tb_elemento", contentValues, "id=" + elemento.getId(), null);
    }

    public void eliminarElemento(int idElemento) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        db.delete("tb_elemento", "id=" + idElemento, null);
    }
}
