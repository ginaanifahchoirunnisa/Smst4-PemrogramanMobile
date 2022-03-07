package com.example.domytask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllTaskView extends Fragment {

    //ad recyclerView member
    public RecyclerView recyclerView;
    public ArrayList<AllTask> listTask = new ArrayList<AllTask>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_list_all_task, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        AllTask task1 = new AllTask("matematika","matter","iya","12");
        AllTask task2 = new AllTask("pkn","matter","iya","12");
        listTask.add(task1);



        //add the following lines to create recyclerView

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new AllTaskAdaptor(listTask));
        return view;
    }


    public void Add_data(AllTask allTask){
        listTask.add(allTask);
    }



}
