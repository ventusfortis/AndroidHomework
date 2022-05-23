package ru.mirea.komissarchuk.mireaproject.ui.story.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Story.class}, version = 2)
public abstract class StoryDB extends RoomDatabase {
    public abstract StoryDao storyDao();
}
