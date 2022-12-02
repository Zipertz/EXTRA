package com.example.extra.entidades;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Libro")
public class Libro {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "titulo")
    public String titulo;
    @ColumnInfo(name = "autor")
    public String autor;
}
