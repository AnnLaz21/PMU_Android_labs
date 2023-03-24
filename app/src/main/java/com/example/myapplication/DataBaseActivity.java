package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class DataBaseActivity extends AppCompatActivity {

    String txtData = "123456";
//    private Handler nHandler = Handler();

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        DataBase mydb = new DataBase(this);
        SQLiteDatabase sqdb = mydb.getWritableDatabase();
        String insertQuery = "INSERT INTO " + mydb.ТАВLЕ_NАМЕ + " (" + mydb.DATE + "," + mydb.USERNAME + ") VALUES ( '19.15.1234', '" + txtData +
                "') ";

        sqdb.execSQL(insertQuery);

        String[] arr = {mydb.UID, mydb.USERNAME};

        Cursor cursor = sqdb.query(
                mydb.ТАВLЕ_NАМЕ, arr, null, null, null, null, null, null
        );

        while (cursor.moveToNext()){
            String data = cursor.getString(cursor.getColumnIndex(mydb.USERNAME));
            Log.i("+++++++LOG_TAG", "NAME " + data);
        }
        cursor.close();
        sqdb.close();
        mydb.close();
    }
}