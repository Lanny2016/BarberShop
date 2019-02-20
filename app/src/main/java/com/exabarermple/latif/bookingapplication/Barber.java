package com.exabarermple.latif.bookingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Barber extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber);

        textViewResult = findViewById(R.id.TextViewResult);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl ( "https://csbarbershopwebapi.azurewebsites.net" )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        createPost();

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "Name: " + post.getName() + "\n";
                    content += "SurName: " + post.getSurname () + "\n";
                    content += "Time: " + post.getTime() + "\n";
                    content += "Date: " + post.getDate() + "\n";
                    content += "RezervationDate: " + post.getRezervationDate () + "\n";
                    content += "isActive: " + post.isActive () + "\n";
                    content += "Tel: " + post.getTelephoneNumber () + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
private void createPost(){



}

}