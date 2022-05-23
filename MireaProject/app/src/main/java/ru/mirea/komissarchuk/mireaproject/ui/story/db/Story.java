package ru.mirea.komissarchuk.mireaproject.ui.story.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Story {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
    public String title;
    public String content;

    public Story(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
