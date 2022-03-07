package com.example.domytask;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllTaskAdaptor extends RecyclerView.Adapter<RecyclerViewHolder> {
    public ArrayList<AllTask> listTask;
    private LayoutInflater layoutInflater;

    public AllTaskAdaptor(ArrayList<AllTask> listTask) {
        this.listTask = listTask;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view  = layoutInflater.inflate(R.layout.item_task , parent , false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getTvmapel().setText(listTask.get(position).getNama_mapel());
        holder.getTvjudul().setText(listTask.get(position).getJudul_task());
        holder.getTvdeskripsi().setText(listTask.get(position).getDeskripsi_task());
        holder.getTvdeadline().setText(listTask.get(position).getDeadline());
    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }

    public class AllTaskHolder extends RecyclerView.ViewHolder{

        TextView tvMapel, tvJudul, tvDesk, tvDeadline;
        public AllTaskHolder(View view)
        {
            super(view); //bawaan sintak

            tvMapel = view.findViewById(R.id.mapel);
            tvJudul = view.findViewById(R.id.judul);
            tvDesk = view.findViewById(R.id.deskripsi);
            tvDeadline = view.findViewById(R.id.deadline);
        }



    }
}
