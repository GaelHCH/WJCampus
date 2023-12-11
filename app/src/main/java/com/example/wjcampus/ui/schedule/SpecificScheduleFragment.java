package com.example.wjcampus.ui.schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wjcampus.R;

public class SpecificScheduleFragment extends Fragment {
    private final boolean regularScheduleScreen;
    private final boolean earlyDismissalScheduleScreen;
    private final boolean twoHourDelayScheduleScreen;
    private final boolean homeroomScheduleScreen;
    private final boolean assembly3A3B3CScheduleScreen;
    private final boolean assemblyDbl3rdScheduleScreen;


    public SpecificScheduleFragment() {
        regularScheduleScreen = false;
        earlyDismissalScheduleScreen = false;
        twoHourDelayScheduleScreen = false;
        homeroomScheduleScreen = false;
        assembly3A3B3CScheduleScreen = false;
        assemblyDbl3rdScheduleScreen = false;
    }

    public SpecificScheduleFragment(boolean regularScheduleScreen, boolean earlyDismissalScheduleScreen, boolean twoHourDelayScheduleScreen, boolean homeroomScheduleScreen, boolean assembly3A3B3CScheduleScreen, boolean assemblyDbl3rdScheduleScreen) {
        this.regularScheduleScreen = regularScheduleScreen;
        this.earlyDismissalScheduleScreen = earlyDismissalScheduleScreen;
        this.twoHourDelayScheduleScreen = twoHourDelayScheduleScreen;
        this.homeroomScheduleScreen = homeroomScheduleScreen;
        this.assembly3A3B3CScheduleScreen = assembly3A3B3CScheduleScreen;
        this.assemblyDbl3rdScheduleScreen = assemblyDbl3rdScheduleScreen;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        This following line is to use findViewById in fragments
        *if you don't want to do getView()
         */
        View rootView = inflater.inflate(R.layout.fragment_specific_schedule, container, false);

        TextView specificScheduleName = (TextView)rootView.findViewById(R.id.scheduleName);
        ImageView specificScheduleImage = (ImageView)rootView.findViewById(R.id.scheduleImage);
        if (regularScheduleScreen) {
            specificScheduleName.setText("Regular");
        }
        else if (earlyDismissalScheduleScreen) {
            specificScheduleName.setText("Early Dismissal");
            specificScheduleImage.setImageResource(R.drawable.earlydismissalschedule1);
        }
        else if (twoHourDelayScheduleScreen) {
            specificScheduleName.setText("Two Hour Delay");
            specificScheduleImage.setImageResource(R.drawable.twohourdelayschedule1);
        }
        else if (homeroomScheduleScreen) {
            specificScheduleName.setText("Homeroom");
            specificScheduleImage.setImageResource(R.drawable.homeroomschedule1);
        }
        else if (assembly3A3B3CScheduleScreen) {
            specificScheduleName.setText("Assembly - 3A, 3B, 3C");
            specificScheduleImage.setImageResource(R.drawable.assembly3abcschedule1);
        }
        else if (assemblyDbl3rdScheduleScreen) {
            specificScheduleName.setText("Assembly - Double 3rd Period");
            specificScheduleImage.setImageResource(R.drawable.assemblydbl3rdschedule1);
        }
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int backBtn2Id = getResources().getIdentifier("backBTN2","id", getContext().getPackageName());
        View backBtn2View = view.findViewById(backBtn2Id);
        backBtn2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Back Button 2 Action");
                AllSchedulesFragment allSchedulesFragment2 = new AllSchedulesFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.container, allSchedulesFragment2).commit();
            }
        });
    }
}