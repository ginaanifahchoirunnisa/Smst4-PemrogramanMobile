package com.example.ytask.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ytask.database.entitas.Task;

import java.util.List;


@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Query("INSERT INTO task (matkul,judul,deskripsi,deadline) VALUES (:matkul, :judul, :deskripsi, :deadline)")
    void insertAll(String matkul, String judul, String deskripsi, String deadline);

    @Query("UPDATE task SET matkul =:matkul, judul =:judul , deskripsi=:deskripsi, deadline = :deadline WHERE taskid=:taskid")
    void update(int taskid, String matkul, String judul, String deskripsi, String deadline);

    //get satu data
    @Query("SELECT * from task WHERE taskid = :taskid")
    Task get(int taskid);

    @Delete
    void delete(Task task);
}
