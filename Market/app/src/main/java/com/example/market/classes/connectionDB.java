package com.example.market.classes;
//importar libreria sql
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// EXTENDS ES LA PALABRA RESERVADA PARA LA HERENCIA

public class connectionDB extends SQLiteOpenHelper {
    public connectionDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        //Create tables
        market.execSQL("create table users(id integer primary key autoincrement not null," +
                "firstname text not null," +
                " lastname text not null," +
                " email text not null, " +
                "password text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
