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
        Button nodeButton1 = new Button(getContext()); Button nodeButton2 = new Button(getContext()); Button nodeButton3 = new Button(getContext());
        Button nodeButton4 = new Button(getContext()); Button nodeButton5 = new Button(getContext());

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
            if (!GFloorExceptions.contains(currRoom)) homeScreenRooms.add(new HomeScreenRoom(currRoom, "Floor: G", R.drawable.classroom1, nodeButton1));
        }
        currRoom = "";

        //First and second floor
        List<String> restOfExceptions = Arrays.asList("s", "s");

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
        ArrayList<HomeScreenRoom> filteredRoomList= new ArrayList<HomeScreenRoom>();
        for (HomeScreenRoom currRoom: homeScreenRooms) {
            if (currRoom.getRoomNum().toLowerCase().contains(text.toLowerCase())) {
                filteredRoomList.add(currRoom);

            }
        }

        //If list is empty report this to user
        if (filteredRoomList.isEmpty()) {
            Toast.makeText(getContext(), "No rooms found : (", Toast.LENGTH_SHORT).show();
        }
        else {
            roomsAdapter.setFilteredList(filteredRoomList);
        }
    }
}