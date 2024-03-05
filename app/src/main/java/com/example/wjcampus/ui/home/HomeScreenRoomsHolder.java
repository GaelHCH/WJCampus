package com.example.wjcampus.ui.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcampus.R;

public class HomeScreenRoomsHolder extends RecyclerView.ViewHolder {

    ImageView subjectImageView;
    TextView floorTextView, roomNumberTextView;
    Button goButtonView;
    public HomeScreenRoomsHolder(@NonNull View itemView) {
        super(itemView);

        //Setting the values as shown in our saved_rooms_view xml
        subjectImageView = itemView.findViewById(R.id.subjectIcon);
        floorTextView = itemView.findViewById(R.id.floorTxt);
        roomNumberTextView = itemView.findViewById(R.id.roomNumberTxt);
        goButtonView = itemView.findViewById(R.id.goToRoomBtn);
    }
}
