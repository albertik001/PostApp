package com.geektech.postapp.data.remote;

import android.text.style.UpdateAppearance;

import com.geektech.postapp.data.models.PostModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostApi {

    @GET("/posts?group=2")
    Call<List<PostModel>> getPost(@Query("group") int group);

    @POST("/posts")
    Call<PostModel> createPost(@Body PostModel postModel);

    @PUT("/posts/{id}")
    Call<ResponseBody> updatePost(@Path("id") int id, @Body PostModel postModel);

    @DELETE("/posts/{id}")
    Call<ResponseBody> deletePost(@Path("id") int id);
}
