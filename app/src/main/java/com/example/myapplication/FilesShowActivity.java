package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class FilesShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_show);

        FileInputStream fin;
        TextView desc = (TextView) findViewById(R.id.textViewDesc);

        try{
            fin = openFileInput("test.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String result = new String(bytes, StandardCharsets.UTF_8);
            fin.close();

            desc.setText(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}