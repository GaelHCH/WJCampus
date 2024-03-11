package com.example.wjcampus.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<HomeScreenRoom> homeScreenRooms = new ArrayList<HomeScreenRoom>();
    private HomeScreenRoomsAdapter roomsAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater,container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Filtering list with the buttons on top
        //Comp Lab Button
        int compLabBTNID = getResources().getIdentifier("compLabBtn", "id", getContext().getPackageName());
        Button compLabBTNVIew = view.findViewById(compLabBTNID);
        compLabBTNVIew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Workshop button
        int mathBTNID = getResources().getIdentifier("mathBtn", "id", getContext().getPackageName());
        Button mathBTNView = view.findViewById(mathBTNID);
        mathBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Math lab button works");
                

            }
        });

        //Science Lab button
        int scienceLabBTNID = getResources().getIdentifier("ScienceLabBtn", "id", getContext().getPackageName());
        Button scienceLabBTNView = view.findViewById(scienceLabBTNID);
        scienceLabBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Gym button
        int gymBTNID = getResources().getIdentifier("gymBtn", "id", getContext().getPackageName());
        Button gymBTNView = view.findViewById(gymBTNID);
        gymBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Courtyard button
        int courtyardBTNID = getResources().getIdentifier("courtyardBtn", "id", getContext().getPackageName());
        Button courtyardBTNView = view.findViewById(courtyardBTNID);
        courtyardBTNView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //Search view reference
        int searchRoomViewID = getResources().getIdentifier("searchRoom", "id", getContext().getPackageName());
        SearchView searchRoomView = view.findViewById(searchRoomViewID);
        searchRoomView.clearFocus();
        searchRoomView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        //Recycler view reference
        int homeScreenRoomsViewID = getResources().getIdentifier("homeScreenRoomsList", "id", getContext().getPackageName());
        RecyclerView homeScreenRoomsView = view.findViewById(homeScreenRoomsViewID);

        //Creating the buttons for the nodes
        Button goButton = new Button(getContext());
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Goes to the map screen with value already in the dest section
            }
        });

        //Adding items to the saved rooms list
        //Ground floor
        String currRoom = "";
        List<String> GFloorExceptions = Arrays.asList("G06","G08", "G15", "G16", "G17", "G18", "G19", "G23", "G24", "G26", "G28", "G29", "G47", "G48", "G49", "G50", "G51"
                ,"G52", "G53", "G54", "G55", "G56", "G57", "G58", "G59", "G60", "G61", "G62", "G63", "G66", "G67", "G72", "G73", "G80");
        for (int a = 2; a < 87; a++) {
            if (a < 10) {
                currRoom = "G0" + a;
            }
            else {
                currRoom = "G"+a;
            }
            //Dealing with exceptions before adding
            if (!GFloorExceptions.contains(currRoom)) homeScreenRooms.add(new HomeScreenRoom(currRoom, "Floor: G", R.drawable.classroom1, goButton));
        }
        currRoom = "";

        //First and second floor
        List<String> restOfExceptions = Arrays.asList("103", "112", "119", "120", "139", "157", "161", "162", "163", "164", "170", "171", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186",
                "187", "188", "189", "197", "198", "201", "202", "206", "212", "216", "217", "218", "219", "240", "251", "252", "253");
        for (int a = 101; a < 259; a++) {
            currRoom = String.valueOf(a);
            if (!restOfExceptions.contains(currRoom)) {
                if (currRoom.substring(0,1).equals("1")) {
                    homeScreenRooms.add(new HomeScreenRoom(currRoom, "Floor: 1st", R.drawable.classroom1, goButton));
                }
                else {
                    homeScreenRooms.add(new HomeScreenRoom(currRoom, "Floor: 2nd", R.drawable.classroom1, goButton));
                }
            }
        }

        //Adding the rest of the building
        homeScreenRooms.add(new HomeScreenRoom("Main Office", "Floor: 1st", R.drawable.classroom1, goButton));
        homeScreenRooms.add(new HomeScreenRoom("Auditorium", "Floor: 1st", R.drawable.classroom1, goButton));
        homeScreenRooms.add(new HomeScreenRoom("Court yard 1", "Floor: 1st", R.drawable.classroom1, goButton));
        homeScreenRooms.add(new HomeScreenRoom("Court yard 2", "Floor: 1st", R.drawable.classroom1, goButton));
        homeScreenRooms.add(new HomeScreenRoom("Cafeteria", "Floor: 1st", R.drawable.classroom1, goButton));
        homeScreenRooms.add(new HomeScreenRoom("TV Studio", "Floor: 1st", R.drawable.classroom1, goButton));

//        homeScreenRooms.add(new HomeScreenRoom("G03", "Floor: G", R.drawable.classroom1, nodeButton1));
//        homeScreenRooms.add(new HomeScreenRoom("124", "Floor: 2", R.drawable.classroom1, nodeButton2));
//        homeScreenRooms.add(new HomeScreenRoom("203", "Floor: 2", R.drawable.classroom1, nodeButton3));
//        homeScreenRooms.add(new HomeScreenRoom("200", "Floor: 2", R.drawable.classroom1, nodeButton4));
//        homeScreenRooms.add(new HomeScreenRoom("G12", "Floor: G", R.drawable.classroom1, nodeButton5));

        //Making it visible and setting the adapter
        homeScreenRoomsView.setLayoutManager(new LinearLayoutManager(getContext()));
        roomsAdapter = new HomeScreenRoomsAdapter(getContext(), homeScreenRooms);
        homeScreenRoomsView.setAdapter(roomsAdapter);

    }

    private void filterList(String text) {
        ArrayList<HomeScreenRoom> filteredRoomList = new ArrayList<HomeScreenRoom>();
        for (HomeScreenRoom currRoom: homeScreenRooms) {
            if (currRoom.getRoomNum().toLowerCase().contains(text.toLowerCase())) {
                filteredRoomList.add(currRoom);

            }
        }
        //If list is empty report this to user
        if (filteredRoomList.isEmpty()) {
//            String regex = "[a-zA-Z&&[^G]]+";
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(text);
//            boolean justText = matcher.matches();
//
//            if (justText) {
//                Toast.makeText(getContext(), "Please enter room NUMBER", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                Toast.makeText(getContext(), "No rooms found", Toast.LENGTH_SHORT).show();
//            }
            Toast.makeText(getContext(), "No rooms found", Toast.LENGTH_SHORT).show();

        }
        else {
            roomsAdapter.setFilteredList(filteredRoomList);
        }

    }
}