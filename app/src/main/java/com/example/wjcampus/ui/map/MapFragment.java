package com.example.wjcampus.ui.map;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentHomeBinding;
import com.example.wjcampus.databinding.FragmentMapBinding;

import java.util.Hashtable;
import java.util.List;

public class MapFragment extends Fragment {

    public SchoolMap schoolMap;
    public Hashtable<String, Room>[] allFloors;
    public Room startRoom;
    public Room destRoom;
    public int startFloor;
    public int destFloor;
    private FragmentMapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        schoolMap = new SchoolMap();

        allFloors = new Hashtable[3];
        allFloors[0] = Floors.getFloor(0);
        allFloors[1] = Floors.getFloor(1);
        allFloors[2] = Floors.getFloor(2);

        //Adding the onClick listeners for the buttons

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);

    }

    /*
    * The method onViewCreated is needed needed to add onclick events for views in fragments
     */
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Adding onClick events for the views

        //startBTN onClick (selectStartRoom(View view))
        int startBtnID = getResources().getIdentifier("startBTN", "id", getContext().getPackageName());
        View startBtnView = view.findViewById(startBtnID);
        startBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use getView() when wanting to access findViewById with fragments instead of activities.
                EditText startSearchBar = getView().findViewById(R.id.startSearchBar);
                String startText = startSearchBar.getText().toString();
                TextView startTextView = getView().findViewById(R.id.startRoom);
                int floorNumber = 0;

                for (Hashtable<String, Room> floor: allFloors) {
                    if(floor.containsKey(startText)){
                        break;
                    }
                    floorNumber++;
                }
                if(floorNumber == 3) {
                    startTextView.setText("DNE");
                    return;
                }
                startRoom = allFloors[floorNumber].get(startText);
                startFloor = floorNumber;
                startTextView.setText(startText);
            }
        });

        //destBTN onclick (selectDestRoom(View view))
        int destBtnID = getResources().getIdentifier("destBTN", "id", getContext().getPackageName());
        View destBtnView = view.findViewById(destBtnID);
        destBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText destSearchBar = getView().findViewById(R.id.destSearchBar);
                String destText = destSearchBar.getText().toString();
                TextView destTextView = getView().findViewById(R.id.destRoom);
                destTextView.setText(destText);

                int floorNumber = 0;

                for (Hashtable<String, Room> floor: allFloors) {
                    if(floor.containsKey(destText)){
                        break;
                    }
                    floorNumber++;
                }
                if(floorNumber == 3) {
                    destTextView.setText("DNE");
                    return;
                }
                destRoom = allFloors[floorNumber].get(destText);
                destFloor = floorNumber;
                destTextView.setText(destText);
            }
        });

        //printBTN onClick (printRoute(View view))
        int printBtnID = getResources().getIdentifier("printBTN", "id", getContext().getPackageName());
        View printBtnView = view.findViewById(printBtnID);
        printBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRoom == null || destRoom == null) {
                    return;
                }
                List<PathResults> results = Path.findShortestPath(startRoom, startFloor, destRoom, destFloor);
                SchoolMap.markPaths(results);
                System.out.println(SchoolMap.printFloor());
            }
        });
    }

}