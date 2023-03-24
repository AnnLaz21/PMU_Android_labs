package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class loginModel {
    private  String login;
    private  String password;

    public loginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);


    }


    public void postHttp(View view){
        postData("name","password");
    }

        private void postData(String name, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://login1.requestcatcher.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        loginModel modal = new loginModel(name, password);
        Call<loginModel> call = retrofitAPI.createPost(modal);
        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel responseFromAPI = response.body();
                String responseString = "Response Code : " + response.code()
                        + "\nlogin : " + responseFromAPI.getLogin() + "\n"
                        + "password : " + responseFromAPI.getPassword()+"\n";

            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {
            }
        });
    }

    public void openWeb(View view) {
        WebView brows = findViewById(R.id.webView);
        brows.loadUrl("https://google.com");
        System.out.println(brows.getOriginalUrl());
    }
}
