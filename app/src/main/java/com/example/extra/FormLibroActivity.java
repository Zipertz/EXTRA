package com.example.extra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.extra.dataBase.AppDataBase;
import com.example.extra.entidades.Libro;
import com.example.extra.service.LibroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormLibroActivity extends AppCompatActivity {

    EditText etTitulo,etAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_libro);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);





    }


    public void enviar (View view){
        String titulo = etTitulo.getText().toString();
        String autor = etAutor.getText().toString();

        Libro libro = new Libro();
        libro.titulo=titulo;
        libro.autor=autor;

        AppDataBase db = AppDataBase.getInstance(this);
        db.librodao().create(libro);

        postRetrofit(libro);
    }
    public void postRetrofit(Libro libro){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63746cd448dfab73a4df8801.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LibroService service = retrofit.create(LibroService.class);
        service.create(libro).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(), "Se creo correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No se creo correctamente", Toast.LENGTH_SHORT).show();
            }
        });

    }


}