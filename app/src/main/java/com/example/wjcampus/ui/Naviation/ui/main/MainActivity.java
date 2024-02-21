package com.example.wjcampus.ui.Naviation.ui.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.wjcampus.R;
import com.example.wjcampus.ui.home.HomeFragment;
import com.example.wjcampus.ui.map.MapFragment;
import com.example.wjcampus.ui.schedule.AllSchedulesFragment;
import com.example.wjcampus.ui.schedule.ScheduleFragment;
import com.example.wjcampus.ui.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView wjCampusBottomNavView;

    HomeFragment homeFragment = new HomeFragment();
    MapFragment mapFragment = new MapFragment();
    ScheduleFragment scheduleFragment = new ScheduleFragment();

    SettingsFragment settingsFragment = new SettingsFragment();

    public FragmentManager fragmentManager = getSupportFragmentManager();

    @NonNull
    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }
//private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To get rid of the actionBar

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //To hide the actionBar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        //To change it's color
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#AFE1AF"));
//        actionBar.setBackgroundDrawable(colorDrawable);

        wjCampusBottomNavView = findViewById(R.id.mainNavMenu);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        //System.out.println("iahjsdfihw0iehf");

        wjCampusBottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //System.out.println("It gets in the clicker function for the nav items");
                int id = item.getItemId();
                int othrItemId = 0;
                if (id==R.id.home) {
                    //System.out.println("It gets on the map click check in MainActivity");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                }
                else if (id==R.id.map) {
                    //System.out.println("It gets on the map click check in MainActivity");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                    return true;
                }
                else if (id==R.id.schedule) {
                    //System.out.println("It gets on the map click check in MainActivity");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment).commit();
                    return true;
                }
                else if (id==R.id.settings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();
                    return true;
                }


//                switch (item.getItemId()) {
//                    case (R.id.home):
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
//                        break;
//
//                    default:
//                }
                return false;

            }
        });
//
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        BottomNavigationView navView = findViewById(R.id.mainNavMenu);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.mainNavMenu, navController);
    }

    /*
    * xml comments:
    * app:layout_constraintBottom_toBottomOf="parent"
    * app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/searchRoom"
        * android:layout_weight="1"

     <FrameLayout
        android:layout_width=""
        android:layout_height=""

     * androidx.constraintlayout.widget.ConstraintLayout
     */
}