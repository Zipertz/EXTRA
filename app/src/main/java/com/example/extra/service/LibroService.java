package com.example.extra.service;



import com.example.extra.entidades.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LibroService {
        @POST("libros")
        Call<Void> create(@Body Libro libro);
        @GET("libros")
        Call<List<Libro>> optenerTodo();
}
