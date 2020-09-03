package com.programmergwin.gadsproject.controls;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiEndpointInterface {
   /*
    @POST("userlogin/add_user")
    Call<JsonResponse<SignUpResponse>> createUser(@Query("jsonString") String jsonString);
    */

    @GET("api/hours")
    Call<ArrayList<LearningUserModel>> getLearningUserList();

    @GET("api/skilliq")
    Call<ArrayList<LearningUserModel>> getSkillIQUserList();
}
