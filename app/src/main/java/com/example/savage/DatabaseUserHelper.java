package com.example.savage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseUserHelper extends SQLiteOpenHelper {
    private static int Version=1;

    public DatabaseUserHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseUserHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, name,null, version);
    }

    //String nome,String numtel,Date dataNasciata,String email,password
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE User(userCode varchar(100) primary key UNIQUE, email varchar(64) , password varchar(64))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
