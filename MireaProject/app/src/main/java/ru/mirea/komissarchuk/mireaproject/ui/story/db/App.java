package ru.mirea.komissarchuk.mireaproject.ui.story.db;

import android.app.Application;
import androidx.room.Room;

public class App extends Application {
    public static App instance;
    private StoryDB database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, StoryDB.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static App getInstance() {
        return instance;
    }
    public StoryDB getDatabase() {
        return database;
    }
}
