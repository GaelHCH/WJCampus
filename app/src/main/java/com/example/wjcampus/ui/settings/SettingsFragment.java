package com.example.wjcampus.ui.settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentMapBinding;
import com.example.wjcampus.ui.schedule.AllSchedulesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsFragment extends Fragment {

    private FragmentMapBinding binding;
    private boolean isDarkModeOn = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Setting the dark mode button action
        int darkModeBtnID = getResources().getIdentifier("darkModeBTN", "id", getContext().getPackageName());
        View darkModeView = view.findViewById(darkModeBtnID);

        darkModeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("Dark Mode switch works");
                if (isDarkModeOn) {
                    System.out.println("Dark Mode switch condition - Turn OFF");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isDarkModeOn = false;
                }
                else {
                    System.out.println("Dark Mode switch condition - Turn ON");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isDarkModeOn = true;
                }
            }
        });
    }
}