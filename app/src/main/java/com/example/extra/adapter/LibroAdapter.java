package com.example.extra.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.extra.R;
import com.example.extra.entidades.Libro;

import java.util.List;


public class LibroAdapter extends  RecyclerView.Adapter{

    List<Libro> data;
    public  LibroAdapter(List<Libro> data){
        this.data=data;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_libro,parent,false);
        return new LibroAdapter.LibroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvTitulo = holder.itemView.findViewById(R.id.tvTitulo);
        tvTitulo.setText(data.get((position)).titulo );

        TextView tvAutor = holder.itemView.findViewById(R.id.tvAutor);
        tvAutor.setText(data.get((position)).autor);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class LibroViewHolder extends RecyclerView.ViewHolder{

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
