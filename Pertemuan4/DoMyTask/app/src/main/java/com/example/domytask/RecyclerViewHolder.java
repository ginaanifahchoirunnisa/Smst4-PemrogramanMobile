package com.example.domytask;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView tvmapel,tvjudul,tvdeskripsi,tvdeadline;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        tvmapel = itemView.findViewById(R.id.mapel);
        tvjudul = itemView.findViewById(R.id.judul);
        tvdeskripsi = itemView.findViewById(R.id.deskripsi);
        tvdeadline = itemView.findViewById(R.id.deadline);
    }

    public TextView getTvjudul() {
        return tvjudul;
    }

    public TextView getTvdeskripsi() {
        return tvdeskripsi;
    }

    public TextView getTvdeadline() {
        return tvdeadline;
    }

    public TextView getTvmapel(){
        return tvmapel;
    }


}
