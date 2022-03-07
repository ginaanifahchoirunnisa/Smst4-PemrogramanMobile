package com.example.domytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_task:
                        startActivity(new Intent(getApplicationContext(),AddTask.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.list_task:
                        startActivity(new Intent(getApplicationContext(),ListAllTask.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;
                }
                return false;
            }
        });

//
//        //set listAllTask selected
//        bottomNavigationView.setSelectedItemId(R.id.list_task);
//
//        //set AddTask selected
//        bottomNavigationView.setSelectedItemId(R.id.add_task);
    }
}