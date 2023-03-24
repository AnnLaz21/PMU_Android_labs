package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class FilesActivity extends AppCompatActivity {

    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_files);
    }

    public void save(View v){

        EditText date = (EditText) findViewById(R.id.editMyDate);
        EditText surname = (EditText) findViewById(R.id.editSurname);
        EditText description = (EditText) findViewById(R.id.editCompleteWork);

        String data = date.getText().toString() + " " + surname.getText().toString() + " " +description.getText().toString();

        FileOutputStream fout = null;

        try{
            fout = openFileOutput("test.txt", MODE_PRIVATE);
            fout.write(data.getBytes());

            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
            fout.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void show(View v){
        Intent intent = new Intent(this, FilesShowActivity.class);
        startActivity(intent);
    }
}