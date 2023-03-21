//package com.example.myapplication;
//import retrofit2.;
//import retrofit2.http.Body;
//import retrofit2.http.POST;
//
//public interface RetrofitAPI {
//
//    // as we are making a post request to post a data
//    // so we are annotating it with post
//    // and along with that we are passing a parameter as users
//    @POST("login1")
//
//    //on below line we are creating a method to post our data.
//    Call <loginModel> createPost(@Body loginModel dataModal);
//}
// class loginModel {
//    private  String login;
//    private  String password;
//    private  String botToken = "42botToken42";
//
//    public loginModel(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    public String getBotToken() {
//        return botToken;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
//
//public class WebActivity {
//    private void postData(String name, String password) {
//
//        // below line is for displaying our progress bar.
//
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        Retrofit retrofit = new Retrofit.Builder()
//                // .baseUrl("https://login1.requestcatcher.com")
//                .baseUrl("https://reqres.in/api/")
//                // as we are sending data in json format so
//                // we have to add Gson converter factory
//                .addConverterFactory(GsonConverterFactory.create())
//                // at last we are building our retrofit builder.
//                .build();
//        // below line is to create an instance for our retrofit api class.
//        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//
//        // passing data from our text fields to our modal class.
//        loginModel modal = new loginModel(name, password);
//
//        // calling a method to create a post and passing our modal class.
//        Call<loginModel> call = retrofitAPI.createPost(modal);
//
//        // on below line we are executing our method.
//        call.enqueue(new Callback<loginModel>() {
//            @Override
//            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
//                // this method is called when we get response from our api.
//
//                // on below line we are setting empty text
//                // to our both edit text.
//
//                // we are getting response from our body
//                // and passing it to our modal class.
//                loginModel responseFromAPI = response.body();
//
//                // on below line we are getting our data from modal class and adding it to our string.
//                String responseString = "Response Code : " + response.code()
//                        + "\nlogin : " + responseFromAPI.getLogin() + "\n"
//                        + "password : " + responseFromAPI.getPassword()+"\n"
//                        + "botToken : "+ responseFromAPI.getBotToken();
//
//                // below line we are setting our
//                // string to our text view.
//                Toast.makeText(MainActivity.this,responseString,Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<loginModel> call, Throwable t) {
//                // setting text to our text view when
//                // we get error response from API.
//                Toast.makeText(MainActivity.this,"Error found is : " + t.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}
