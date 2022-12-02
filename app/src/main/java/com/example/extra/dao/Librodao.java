package com.example.extra.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.extra.entidades.Libro;

import java.util.List;

@Dao
public interface Librodao {
    @Query("SELECT * FROM Libro")
    List<Libro> getAll();

    @Query("SELECT * FROM Libro where id = :id")
    Libro find(int id);

    @Insert
    void create(Libro libro);

    @Update
    void update(Libro libro);

    @Delete
    void delete(Libro libro);
}
