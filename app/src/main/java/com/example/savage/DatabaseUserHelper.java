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
        String sql="CREATE TABLE User(userCode varchar(100) primary key UNIQUE,nome varchar(64),numtel varchar(12),dataNascita date, email varchar(64) UNIQUE,password varchar(64))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  static  SQLiteDatabase  createDBUser(char flag,Context c,int version){

        DatabaseUserHelper dbHelper=new DatabaseUserHelper(c,"User_DB",version);
        // db sia per lettura e scrittura
        SQLiteDatabase db=null;
        if(flag=='w'){
            db=dbHelper.getWritableDatabase();
        }else if(flag=='r'){
            db=dbHelper.getReadableDatabase();
        }
        // db solo per lettura
        //SQLiteDatabase db=dbHelper.getReadableDatabase();

        return db;
    }

}
