package com.geektech.postapp.data.remote;

import com.geektech.postapp.data.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostApi {

    @GET("/posts")
    Call<List<PostModel>> getPost();

    @POST("/posts")
    Call<PostModel> createPost(@Body PostModel postModel);
}
