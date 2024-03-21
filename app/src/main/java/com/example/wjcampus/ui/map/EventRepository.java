package com.example.wjcampus.ui.map;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class EventRepository {

    private EventDao eventDao;

    public EventRepository(Context context) {
        EventDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                EventDatabase.class, "event-database").build();
        eventDao = db.eventDao();
    }

    public void insertEvent(Event event) {
        eventDao.insertEvent(event);
    }

    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }
}
