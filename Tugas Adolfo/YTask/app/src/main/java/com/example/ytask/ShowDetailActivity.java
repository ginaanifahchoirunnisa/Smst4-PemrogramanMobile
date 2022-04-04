package com.example.ytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ytask.database.AppDatabase;
import com.example.ytask.database.entitas.Task;

public class ShowDetailActivity extends AppCompatActivity {
    private AppDatabase database;
    private int id ;
    private TextView showMatkul, showJudul, showDeskripsi, showDeadline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        showMatkul = findViewById(R.id.show_matkul);
        showJudul = findViewById(R.id.show_judul);
        showDeskripsi = findViewById(R.id.show_deskripsi);
        showDeadline = findViewById(R.id.show_deadline);

        database = AppDatabase.getInstance(getApplicationContext());


        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);

        Task task = database.taskDao().get(id);
        showMatkul.setText(task.matkul);
        showJudul.setText(task.judultugas);
        showDeskripsi.setText(task.deskripsitugas);
        showDeadline.setText(task.deadline);
    }
}