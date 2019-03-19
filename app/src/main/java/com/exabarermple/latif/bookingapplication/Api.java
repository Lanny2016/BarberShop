package com.exabarermple.latif.bookingapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "https://csbarbershopwebapi.azurewebsites.net";

    @GET("api/GetAll/")
    Call<List<Contacts>> getContacts();

    //The register call
    @FormUrlEncoded
    @POST("/api/create/")
    Call<Contacts> createOrder(
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("date") String date,
            @Field("time") String time,
            @Field("telephoneNumber") String phoneNumber,
            @Field("rezervationDate") String rezervationDate,
            @Field("isActive") boolean isActive);

    @POST("/api/create/")
    Call<Contacts> createOrder(@Body Contacts post);
}
