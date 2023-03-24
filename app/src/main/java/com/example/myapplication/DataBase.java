package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    static String DATAВASE_NAМE="android_database.db";
    private static Integer DATAВASE_VERSION = 1;
    public String UID ="_id";
    public String DATE = "date";
    public String USERNAME = "username";
    public  String ТАВLЕ_NАМЕ = "otchet";

    private  String SQL_CREATE_ENТRIES = "CREATE TABLE "+ ТАВLЕ_NАМЕ +
            " ( " + UID +" integer primary key autoincrement,"+
            DATE + " VARCHAR(255), "+USERNAME+" VARCHAR(255));";

    private String SQL_DELETE_ENТRIES ="DROP TABLE IF EXISTS" +
            ТАВLЕ_NАМЕ;

   public DataBase(Context context){
        super(context, DATAВASE_NAМE,null, DATAВASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.SQL_CREATE_ENТRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.SQL_DELETE_ENТRIES);
        onCreate (db) ;
    }
}
