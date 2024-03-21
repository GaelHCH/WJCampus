package com.example.wjcampus.ui.schedule;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.wjcampus.ui.map.Event;
import com.example.wjcampus.ui.map.EventDao;

import java.util.List;

public class EventViewModel extends ViewModel {
    private EventDao myDao;

    public EventViewModel(EventDao myDao) {
        this.myDao = myDao;
    }

    public LiveData<List<Event>> getAllItems() {
        MutableLiveData<List<Event>> data = new MutableLiveData<>();
        new AsyncTask<Void, Void, List<Event>>() {
            @Override
            protected List<Event> doInBackground(Void... voids) {
                return myDao.getAllEvents();
            }

            @Override
            protected void onPostExecute(List<Event> items) {
                data.setValue(items);
            }
        }.execute();
        return data;
    }

    public void insertItem(Event item) {
        new AsyncTask<Event, Void, Void>() {
            @Override
            protected Void doInBackground(Event... items) {
                myDao.insertEvent (items[0]);
                return null;
            }
        }.execute(item);
    }
}

