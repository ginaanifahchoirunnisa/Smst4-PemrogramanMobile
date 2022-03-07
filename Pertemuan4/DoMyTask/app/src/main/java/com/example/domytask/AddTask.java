package com.example.domytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTask extends AppCompatActivity {

    //variabel untuk komponen
    TextView judul ,textViewJudul,textViewMapel,textViewDeskripsi,textViewDeadline;
    EditText e_judul_task,e_nama_mapel,e_deskripsi_task,e_deadline_task;

    //variabel me-refresh database firebase
    private DatabaseReference database;

    //variabel komponen
    Button button_tambahkan;
    SharedPreferences.Editor setData;
    SharedPreferences getData;
    AllTaskView allTaskView = new AllTaskView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        setData = getSharedPreferences("data",MODE_PRIVATE).edit();
        getData = getSharedPreferences("data", MODE_PRIVATE);
        judul = findViewById(R.id.judul);
        e_nama_mapel = findViewById(R.id.i_nama_mapel);
        e_judul_task = findViewById(R.id.i_judul_task);
        e_deskripsi_task = findViewById(R.id.i_deskripsi_task);
        e_deadline_task = findViewById(R.id.i_deadline_task);
        button_tambahkan = findViewById(R.id.button_tambahkan);


        //memanggil firebase database
        database = FirebaseDatabase.getInstance().getReference();


        //jika session_mapel ada maka ,
        if(getData.contains("session_mapel"))
        {
            if(getData.contains("session_judul"))
            {
                if(getData.contains("session_deskripsi"))
                {
                    if(getData.contains("session_deadline"))
                    {
                        AllTask allTask = new AllTask(getData.getString("session_mapel", null),(getData.getString("session_judul", null)
                        ),(getData.getString("session_deskripsi", null)
                        ),(getData.getString("session_deadline", null)));
                        allTaskView.Add_data(allTask);

                    }
                }
            }
        }

        button_tambahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ngecek apakah yang diinputkan itu kosong atau tidak
                if(TextUtils.isEmpty(e_nama_mapel.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Jenis mata pelajaran tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(e_judul_task.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Judul task tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(e_deskripsi_task.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Deskripsi task tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(e_deadline_task.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Deadline task tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    simpan_data(new AllTask(e_nama_mapel.getText().toString(),e_judul_task.getText().toString(),e_deskripsi_task.getText().toString(),e_deadline_task.getText().toString()));
                }
//                setData.putString("session_mapel", e_nama_mapel.getText().toString() );
//                setData.putString("session_judul", e_judul_task.getText().toString() );
//                setData.putString("session_deksripsi", e_deskripsi_task.getText().toString() );
//                setData.putString("session_deadline", e_deadline_task.getText().toString() );
//                setData.apply();
//
//                judul.setText(e_deadline_task.getText().toString());



            }
        });





        //inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.add_task);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.list_task:
                        startActivity(new Intent(getApplicationContext(),ListAllTask.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.add_task:
                        return true;
                }
                return false;
            }
        });
    }



    //program simpan data
    private void simpan_data(AllTask allTask)
    {
        //didalam child(`namadatabase`), setValue --> digunakan untuk menanamkan data nya ke class AllTask
        database.child("dbtask").push().setValue(allTask).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                //ketika data sukses tersimpan
                Toast.makeText(getApplicationContext(),"Data Tersimpan",Toast.LENGTH_SHORT).show();
                e_nama_mapel.setText("");
                e_judul_task.setText("");
                e_deskripsi_task.setText("");
                e_deadline_task.setText("");
            }
        });
    }

    //kemana dia apabila data sudah tersimpan
    public static Intent getAcInten(Activity activity){
        return new Intent(activity,AllTaskView.class);
    }
}