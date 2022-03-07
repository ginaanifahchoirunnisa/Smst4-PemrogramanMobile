package com.example.domytask;
import com.google.firebase.database.IgnoreExtraProperties;
public class AllTask {

    private String nama_mapel;
    private String judul_task;
    private String deskripsi_task;
    private String deadline;

    public AllTask()
    {

    }

    public AllTask(String nama_mapel, String judul_task, String deskripsi_task, String deadline) {
        this.nama_mapel = nama_mapel;
        this.judul_task = judul_task;
        this.deskripsi_task = deskripsi_task;
        this.deadline = deadline;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getJudul_task() {
        return judul_task;
    }

    public void setJudul_task(String judul_task) {
        this.judul_task = judul_task;
    }

    public String getDeskripsi_task() {
        return deskripsi_task;
    }

    public void setDeskripsi_task(String deskripsi_task) {
        this.deskripsi_task = deskripsi_task;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    //untuk melakukan penampungan kedalam firebase
    public String toString()
    {
        return " "+nama_mapel+"\n"+judul_task+"\n"+deskripsi_task+"\n"+deadline;
    }


}

