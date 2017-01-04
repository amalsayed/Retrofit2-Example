package com.example.fume02.retrofittest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Eslam El-hoseiny on 11/18/2016.
 */

public interface RequestInterface {


    @POST("setting/get-brands")
    Call<JSONResponse> getJSON( @Body ReqData field1);
}
