package com.example.fume02.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    int helper=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3altareeq.com/tareeq/api/web/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Call<JSONResponse> call = requestInterface.getJSON(new ReqData("en"));

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                //Toast.makeText(MainActivity.this, jsonResponse.status, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,jsonResponse.status+" ",Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,jsonResponse.getAndroid().get(0).title+" ",Toast.LENGTH_LONG).show();


            }


            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
