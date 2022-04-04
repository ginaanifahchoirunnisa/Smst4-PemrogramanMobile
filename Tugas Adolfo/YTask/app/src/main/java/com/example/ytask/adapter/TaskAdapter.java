package com.example.ytask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ytask.R;
import com.example.ytask.database.entitas.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewAdapter> {

    private List<Task> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog
    {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog)
    {
        this.dialog = dialog;
    }

    public TaskAdapter(Context context, List<Task> list)
    {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_task, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.matkul.setText(list.get(position).matkul);
//        holder.judul_task.setText(list.get(position).judultugas);
//        holder.deskripsi.setText(list.get(position).deskripsitugas);
        holder.deadline.setText(list.get(position).deadline);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView matkul,judul_task,deskripsi,deadline;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            matkul = itemView.findViewById(R.id.tmatkul);
//            judul_task = itemView.findViewById(R.id.tjudultugas);
//            deskripsi = itemView.findViewById(R.id.tdeskripsi);
            deadline = itemView.findViewById(R.id.tdeadline);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialog!=null)
                    {
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });

        }
    }

}
