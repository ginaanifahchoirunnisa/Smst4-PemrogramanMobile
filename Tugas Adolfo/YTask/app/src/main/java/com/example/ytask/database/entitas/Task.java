package com.example.ytask.database.entitas;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey
    public int taskid;

    @ColumnInfo
    public String matkul;

    @ColumnInfo(name = "judul")
    public String judultugas;

    @ColumnInfo(name = "deskripsi")
    public String deskripsitugas;

    @ColumnInfo
    public String deadline;


}
