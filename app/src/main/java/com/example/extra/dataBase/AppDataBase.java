package com.example.extra.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.extra.dao.Librodao;
import com.example.extra.entidades.Libro;

@Database(entities = {Libro.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract Librodao librodao();

    public static AppDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "extra")
                .allowMainThreadQueries()
                .build();
    }
}
