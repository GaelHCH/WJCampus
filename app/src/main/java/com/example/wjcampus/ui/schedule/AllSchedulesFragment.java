package com.example.wjcampus.ui.schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wjcampus.R;

public class AllSchedulesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_schedules, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int backBtnId = getResources().getIdentifier("backBTN1","id", getContext().getPackageName());
        View backBtnView = view.findViewById(backBtnId);
        backBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Back Button 1 Action");
                ScheduleFragment scheduleFragment2 = new ScheduleFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment2).commit();
            }
        });

        //Configuring the buttons of the all schedule screen
        int regularSchdleBtnID = getResources().getIdentifier("regularScheduleBTN","id", getContext().getPackageName());
        View regularSchdleBtnView = view.findViewById(regularSchdleBtnID);
        regularSchdleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment regularScheduleFragment = new SpecificScheduleFragment(true,false,false,false,false,false);
                getParentFragmentManager().beginTransaction().replace(R.id.container, regularScheduleFragment).commit();
            }
        });

        int earlyDismissalSchdleBtnID = getResources().getIdentifier("earlyDismissalBTN","id", getContext().getPackageName());
        View earlyDismissalSchdleBtnView = view.findViewById(earlyDismissalSchdleBtnID);
        earlyDismissalSchdleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment earlyDismissalScheduleFragment = new SpecificScheduleFragment(false,true,false,false,false,false);
                getParentFragmentManager().beginTransaction().replace(R.id.container, earlyDismissalScheduleFragment).commit();
            }
        });

        int twoHourDelaySchdleBtnID = getResources().getIdentifier("twoHourDelayBTN","id", getContext().getPackageName());
        View twoHourDelaySchdleBtnView = view.findViewById(twoHourDelaySchdleBtnID);
        twoHourDelaySchdleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment twoHourDelayScheduleFragment = new SpecificScheduleFragment(false,false,true,false,false,false);
                getParentFragmentManager().beginTransaction().replace(R.id.container, twoHourDelayScheduleFragment).commit();
            }
        });

        int homeroomSchdleBtnID = getResources().getIdentifier("homeroomBTN","id", getContext().getPackageName());
        View homeroomScheduleBtnView = view.findViewById(homeroomSchdleBtnID);
        homeroomScheduleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment homeroomScheduleFragment = new SpecificScheduleFragment(false,false,false,true,false,false);
                getParentFragmentManager().beginTransaction().replace(R.id.container, homeroomScheduleFragment).commit();
            }
        });

        int assembly1SchdleBtnID = getResources().getIdentifier("assemblyBTN1","id", getContext().getPackageName());
        View assembly1ScheduleBtnView = view.findViewById(assembly1SchdleBtnID);
        assembly1ScheduleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment assembly1ScheduleFragment = new SpecificScheduleFragment(false,false,false,false,true,false);
                getParentFragmentManager().beginTransaction().replace(R.id.container, assembly1ScheduleFragment).commit();
            }
        });

        int assembly2SchdleBtnID = getResources().getIdentifier("assemblyBTN2","id", getContext().getPackageName());
        View assembly2ScheduleBtnView = view.findViewById(assembly2SchdleBtnID);
        assembly2ScheduleBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificScheduleFragment assembly2ScheduleFragment = new SpecificScheduleFragment(false,false,false,false,false,true);
                getParentFragmentManager().beginTransaction().replace(R.id.container, assembly2ScheduleFragment).commit();
            }
        });
    }
}