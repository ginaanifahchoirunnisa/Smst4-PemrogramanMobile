package com.example.ytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ytask.adapter.TaskAdapter;
import com.example.ytask.database.AppDatabase;
import com.example.ytask.database.entitas.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnTambah;
    private AppDatabase database;
    private TaskAdapter taskAdapter;
    private List<Task> list = new ArrayList<>();
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        recyclerView = findViewById(R.id.recycler_view);

        btnTambah = findViewById(R.id.btn_tambah);
        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.taskDao().getAll());
        taskAdapter = new TaskAdapter(getApplicationContext(), list);

        //aksi membuat dialog
        taskAdapter.setDialog(new TaskAdapter.Dialog() {
            @Override
            public void onClick(int position) {
                //membuat alert dialog
                final CharSequence[] dialogItem = {"lihat detail", "edit", "hapus"};
                dialog = new AlertDialog.Builder(TaskActivity.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i)
                        {
                            case 0:
                                Intent detilIntent = new Intent(TaskActivity.this, ShowDetailActivity.class);
                                detilIntent.putExtra("id",list.get(position).taskid);
                                detilIntent.putExtra("matkul", list.get(position).matkul);
                                detilIntent.putExtra("judul", list.get(position).judultugas);
                                detilIntent.putExtra("deskripsi", list.get(position).deskripsitugas);
                                detilIntent.putExtra("deadline", list.get(position).deadline);
                                startActivity(detilIntent);
                                break;

                            case 1:
                                Intent intent = new Intent(TaskActivity.this, TambahActivity.class);
                                intent.putExtra("taskid", list.get(position).taskid);
                                startActivity(intent);
                                break;

                            case 2:
                                Task task  = list.get(position);
                                database.taskDao().delete(task);
                                onStart(); //untuk refresh
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(taskAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaskActivity.this, TambahActivity.class));
            }
        });
    }

    //refresh
    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.taskDao().getAll());

        //kirim notifikasi ke adapter
        taskAdapter.notifyDataSetChanged();
    }
}