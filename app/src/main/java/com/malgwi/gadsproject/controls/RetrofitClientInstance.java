package com.malgwi.gadsproject.controls;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    public static final String BASE_URL1 = "https://gadsapi.herokuapp.com/";

    public static Retrofit getRetrofitInstance () {

        if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL1)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
        }
        
        return retrofit;
    }
}
