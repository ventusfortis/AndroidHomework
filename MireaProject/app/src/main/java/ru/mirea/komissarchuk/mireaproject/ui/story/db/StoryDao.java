package ru.mirea.komissarchuk.mireaproject.ui.story.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StoryDao {
    @Query("SELECT * FROM Story")
    List<Story> getAll();

    @Query("SELECT * FROM Story WHERE title LIKE :title LIMIT 1")
    Story findByTitle(String title);

    @Query("SELECT * FROM Story WHERE id = (:id)")
    Story getById(int id);

    @Insert
    void insertAll(Story... stories);

    @Insert
    void insert(Story story);

    @Update
    void update(Story story);

    @Delete
    void delete(Story story);

    @Query("DELETE FROM Story")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM Story")
    int getCount();
}
