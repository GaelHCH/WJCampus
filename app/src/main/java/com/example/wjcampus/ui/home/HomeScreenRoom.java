package com.example.wjcampus.ui.home;

import android.widget.Button;

public class HomeScreenRoom {
    String roomNum;
    String floor;
    int image;
    Button goButton;

    public HomeScreenRoom(String roomNum, String floor, int image, Button goButton) {
        this.roomNum = roomNum;
        this.floor = floor;
        this.image = image;
        this.goButton = goButton;
    }

    public int getImage() {
        return image;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getFloor() {
        return floor;
    }

    public Button getGoButton() {
        return goButton;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setGoButton(Button goButton) {
        this.goButton = goButton;
    }
}

