package com.johannfjs.mod2class1_1.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by johannfjs on 25/05/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, "class1.db", null, 1);
    }

    //Se ejecuta solamente la primera vez que se instala la aplicación
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table tb_tema (id integer primary key autoincrement," +
                        "descripcion varchar(100))"
        );
        db.execSQL(
                "create table tb_elemento (id integer primary key autoincrement," +
                        "id_tema integer," +
                        "titulo varchar(100)," +
                        "descripcion varchar(500))"
        );
        db.execSQL(
                "insert into tb_tema (descripcion) values('Tema 1')"
        );
        db.execSQL(
                "insert into tb_tema (descripcion) values('Tema 2')"
        );
        db.execSQL(
                "insert into tb_tema (descripcion) values('Tema 3')"
        );
    }

    //Se ejecuta cada vez que la versión de base de datos varie
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 2) {
            //Todas las sentencias
        }
    }
}
