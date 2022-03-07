package com.example.domytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListAllTask extends AppCompatActivity {


    //ad recyclerView member
    public RecyclerView recyclerView;
    public ArrayList<AllTask> listTask = new ArrayList<AllTask>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_task);

        recyclerView = findViewById(R.id.recyclerview);

        AllTask task1 = new AllTask("matematika","matter","iya","12");
        AllTask task2 = new AllTask("pkn","matter","iya","12");
        listTask.add(task1);
        listTask.add(task2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AllTaskAdaptor(listTask));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        //inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.list_task);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_task:
                        startActivity(new Intent(getApplicationContext(),AddTask.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.list_task:
                        return true;
                }
                return false;
            }
        });
    }
}