package com.exabarermple.latif.bookingapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("/api/GetAll")
    Call<List<Post>> getPosts();
    @POST("/api/GetAll")
    Call<Post> createPost(@Body Post post);
}
