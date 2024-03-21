package com.example.wjcampus.ui.schedule;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentMapBinding;
import com.example.wjcampus.ui.map.Event;
import com.example.wjcampus.ui.map.EventDatabase;
import com.example.wjcampus.ui.map.ScheduleHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import android.app.Activity;


public class ScheduleFragment extends Fragment {

    private static EventDatabase database;


    private FragmentMapBinding binding;

    private final AllSchedulesFragment allSchedulesFragment = new AllSchedulesFragment();

    private BottomNavigationView wjCampusBottomNavView;
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private EventViewModel viewModel;
    private int currDateInd = -1;
    private List<Event> eventList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = view. findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new EventAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Adding onClick events for the views
        int allSchedulesBTNID = getResources().getIdentifier("allScedulesBTN", "id", getContext().getPackageName());
        View allSchedulesView = view.findViewById(allSchedulesBTNID);

        int leftScheduleBTNid = getResources().getIdentifier("leftSchedule", "id", getContext().getPackageName());
        View leftScheduleBTN = view.findViewById(leftScheduleBTNid);

        int rightScheduleBTNid = getResources().getIdentifier("rightSchedule", "id", getContext().getPackageName());
        View rightScheduleBTN = view.findViewById(rightScheduleBTNid);

        if (database == null) {
            ScheduleHelper schedule =  new ScheduleHelper();
            schedule.execute("https://calendar.google.com/calendar/ical/wjhswebmaster%40gmail.com/public/basic.ics");

            database = Room.databaseBuilder(
                    requireContext(),
                    EventDatabase.class, "eventsList"
            ).build();
        }
        EventViewModelFactory factory = new EventViewModelFactory(database.eventDao());
        viewModel = new ViewModelProvider(this, factory).get(EventViewModel.class);

        viewModel.getAllItems().observeForever(new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> items) {
                List<Event> currEvents = presentEvents(items);
                adapter.setEventList(currEvents);
                adapter.notifyDataSetChanged();
                eventList = items;
            }
        });



        allSchedulesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("All Schedules Button Action");
                getParentFragmentManager().beginTransaction().replace(R.id.container, allSchedulesFragment).commit();
            }
        });

        leftScheduleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               scheduleLeft();
            }
        });

        rightScheduleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleRight();
            }
        });
    }

    public void scheduleRight() {
        if(currDateInd + 10 >= eventList.size()) {
            return;
        }
        currDateInd += 10;

        List<Event> currEvents = presentEvents(eventList);
        adapter.setEventList(currEvents);
        adapter.notifyDataSetChanged();
    }

    public void scheduleLeft() {
        if(currDateInd - 10 < 0) {
            return;
        }
        currDateInd -= 10;
        List<Event> currEvents = presentEvents(eventList);
        adapter.setEventList(currEvents);
        adapter.notifyDataSetChanged();
    }

    private class getExistingEvent extends AsyncTask<Void, Void, List<Event>> {

        @Override
        protected List<Event> doInBackground(Void... params) {
            List<Event> currEvents = presentEvents(database.eventDao().getAllEvents());

            return currEvents;
        }

        @Override
        protected void onPostExecute(List<Event> currEvents) {
            adapter.setEventList(currEvents);
            adapter.notifyDataSetChanged();
        }
    }

    public List<Event> presentEvents(List<Event> items) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        List<Event> shownEvents = new ArrayList<>();
        if(currDateInd == -1) {
            int currDate = 0;
            while (shownEvents.size() < 10) {
                if (items.get(currDate).getDay().after(today)) {
                    shownEvents.add(items.get(currDate));
                }
                currDate++;
            }
            currDateInd = currDate - 9;
        } else {
            for(int i = currDateInd; i < currDateInd+10; i++) {
                shownEvents.add(items.get(i));
            }
        }
        return shownEvents;
    }

    public static void updateDatabase(Event[] data) {
        database.clearAllTables();
        List<Event> eventList = new ArrayList<>(Arrays.asList(data));
        database.eventDao().insertAll(eventList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        database.close();
        viewModel.getAllItems().removeObservers(this);
    }
}