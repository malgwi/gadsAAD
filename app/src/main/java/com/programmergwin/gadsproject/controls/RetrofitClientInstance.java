package com.programmergwin.gadsproject.controls;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    public static String BASE_URL = "";
    public static final String BASE_URL1 = "https://gadsapi.herokuapp.com/";
    public static final String BASE_URL2 = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/";

    public static Retrofit getRetrofitInstance (int par) {
        if(par==1)
            BASE_URL=BASE_URL1;
        else
            BASE_URL=BASE_URL2;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        
        return retrofit;
    }
}
