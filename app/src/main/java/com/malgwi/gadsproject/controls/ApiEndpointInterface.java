package com.malgwi.gadsproject.controls;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpointInterface {
   // @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    // Call<SubmissionModel> submitProject(@Query("jsonString") String jsonString);

    @POST("formResponse")
    @FormUrlEncoded
    Call<Void> SubmitProject(
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086")String lastName,
            @Field("entry.1824927963")String emailAddress,
            @Field("entry.284483984")String projectLink
    );

    @GET("api/hours")
    Call<ArrayList<LearningUserModel>> getLearningUserList();

    @GET("api/skilliq")
    Call<ArrayList<LearningUserModel>> getSkillIQUserList();
}
