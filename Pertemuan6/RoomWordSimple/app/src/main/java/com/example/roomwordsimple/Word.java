package com.example.roomwordsimple;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

/*
* This class will describe the Entity (which represents the SQLite table) for your words.
* Each property in the class represents a column in the table.
* Room will ultimately use these properties to both create the table and instantiate objects from rows in the database.*/
@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}
