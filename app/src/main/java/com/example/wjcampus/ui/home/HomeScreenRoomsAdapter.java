package com.example.wjcampus.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcampus.R;

import java.util.ArrayList;

public class HomeScreenRoomsAdapter extends RecyclerView.Adapter<HomeScreenRoomsHolder> {
    Context context;
    ArrayList<HomeScreenRoom> homeScreenRooms;

    public HomeScreenRoomsAdapter(Context context, ArrayList<HomeScreenRoom> homeScreenRoomsList) {
        this.context = context;
        this.homeScreenRooms = homeScreenRoomsList;
    }

    public void setFilteredList(ArrayList<HomeScreenRoom> list) {
        this.homeScreenRooms = list;
        //New method (may be useful in the future)
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HomeScreenRoomsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeScreenRoomsHolder(LayoutInflater.from(context).inflate(R.layout.home_screen_rooms_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeScreenRoomsHolder holder, int position) {
        //Floor text binding
        holder.floorTextView.setText(homeScreenRooms.get(position).getFloor());
        //Room number text binding
        holder.roomNumberTextView.setText(homeScreenRooms.get(position).getRoomNum());
        //Subject Image binding
        holder.subjectImageView.setImageResource(homeScreenRooms.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return homeScreenRooms.size();
    }
}
