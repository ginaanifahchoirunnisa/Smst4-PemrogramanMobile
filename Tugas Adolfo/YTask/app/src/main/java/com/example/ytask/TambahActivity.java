package com.example.ytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ytask.database.AppDatabase;
import com.example.ytask.database.entitas.Task;

import java.util.ArrayList;
import java.util.List;

public class TambahActivity extends AppCompatActivity {

    private EditText editMatkul,editJudul, editDeskripsi,editDeadline;
    private Button btnSave;
    private AppDatabase database;
    private boolean isEdit = false; //untuk memastikan apakah itu edit
    private int taskid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);


        editMatkul = findViewById(R.id.fmatkul);
        editJudul = findViewById(R.id.fjudul_matkul);
        editDeskripsi = findViewById(R.id.fdeskripsi);
        editDeadline = findViewById(R.id.fdeadline);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        //sekarang activity ini bukan hanya menangani fungsi add namun bisa juga untuk melakukan edit
        Intent intent = getIntent();
        //ketika taskid lebih dari 0 maka disebut edit, kalau tidak , ya berarti hapus
        taskid = intent.getIntExtra("taskid", 0); //mengambil kiriman dari intent activity
        if(taskid>0)
        {
            //ketika itu adalah edit button
            isEdit = true; //set is Edit menjadi true
            //mengambil data - per satu data
            Task task = database.taskDao().get(taskid);
            editMatkul.setText(task.matkul);
            editJudul.setText(task.judultugas);
            editDeskripsi.setText(task.deskripsitugas);
            editDeadline.setText(task.deadline);



        }else{ //kalau  tidak ada data dari "taskid" yang dikirim
            //maka set isEdit nya menjadi 0
            isEdit = false;

        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEdit){ //jika merupakan edit
                    database.taskDao().update(taskid,editMatkul.getText().toString(),editJudul.getText().toString(),editDeskripsi.getText().toString(),editDeadline.getText().toString());
                }else{
                    database.taskDao().insertAll(editMatkul.getText().toString(),editJudul.getText().toString(),editDeskripsi.getText().toString(),editDeadline.getText().toString());
                }


                finish();
            }
        });


    }
}