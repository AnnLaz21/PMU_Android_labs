package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity2 extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 25;
    private static final String CHANNEL_ID = "chanelID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createNotificationChannel();

        Notification.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(this, CHANNEL_ID);
        }

        builder
                .setContentTitle("Уведомление")
                .setSmallIcon(androidx.core.R.drawable.notification_template_icon_bg)
                .setContentText("вы зашли в приложение");


        Notification someBuild = builder.build();

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, someBuild);

        alertDia();
    }

    public void alertDia(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder (this);
        alt_bld.setMessage("Вы хотите продолжить?")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.setTitle("Уведомление");
        alert.show();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Char";
            String description = "Desc";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_web: {
                Intent intent = new Intent(this, WebActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_dataBase: {
                Intent intent = new Intent(this, DataBaseActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.text_2: {
                Intent intent = new Intent(this, FilesActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return false;
    }
}