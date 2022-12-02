package com.example.extra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.extra.adapter.LibroAdapter;
import com.example.extra.dataBase.AppDataBase;
import com.example.extra.entidades.Libro;
import com.example.extra.service.LibroService;
import com.google.gson.Gson;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaLibroActivity extends AppCompatActivity {
    private RecyclerView rvListaLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libro);

        AppDataBase db = AppDataBase.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63746cd448dfab73a4df8801.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LibroService service = retrofit.create(LibroService.class);
        service.optenerTodo().enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                List<Libro> data = response.body();
                Log.i("Main_aoo", "Response: " + response.body().size());




                for(int i = 0;i<data.size();i++){
                    Libro peliculaAux = data.get(i);
                    if(peliculaAux != null){
                        db.librodao().update(peliculaAux);
                    }
                    else{
                        db.librodao().create(peliculaAux);
                    }
                }

                List<Libro> libros = db.librodao().getAll();
                Log.i("Mainn",new Gson().toJson(libros));



                rvListaLibros = findViewById(R.id.rvListaLibros);
                rvListaLibros.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvListaLibros.setAdapter(new LibroAdapter(data));


            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {

            }
        });









    }


}