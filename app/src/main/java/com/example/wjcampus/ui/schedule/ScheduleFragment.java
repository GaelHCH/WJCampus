package com.example.wjcampus.ui.schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentMapBinding;
import com.example.wjcampus.ui.Naviation.ui.main.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScheduleFragment extends Fragment {

    private FragmentMapBinding binding;

    private final AllSchedulesFragment allSchedulesFragment = new AllSchedulesFragment();

    private BottomNavigationView wjCampusBottomNavView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Adding onClick events for the views
        int allSchedulesBTNID = getResources().getIdentifier("allScedulesBTN", "id", getContext().getPackageName());
        View allSchedulesView = view.findViewById(allSchedulesBTNID);
        allSchedulesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("All Schedules Button Action");
                getParentFragmentManager().beginTransaction().replace(R.id.container, allSchedulesFragment).commit();
            }
        });
    }
}