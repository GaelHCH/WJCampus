package com.example.wjcampus.ui.map;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertEvent(Event event);

    @Insert
    void insertAll(List<Event> events);

    @Query("SELECT * FROM events")
    List<Event> getAllEvents();
}



