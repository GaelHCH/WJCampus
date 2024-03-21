package com.example.wjcampus.ui.schedule;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.wjcampus.ui.map.EventDao;

public class EventViewModelFactory implements ViewModelProvider.Factory {
    private EventDao myDao;

    public EventViewModelFactory(EventDao myDao) {
        this.myDao = myDao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(EventViewModel.class)) {
            return (T) new EventViewModel(myDao);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
