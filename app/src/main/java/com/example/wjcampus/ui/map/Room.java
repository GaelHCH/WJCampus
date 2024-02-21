package com.example.wjcampus.ui.map;

import java.util.List;

enum Direction {
    Top,
    Bottom,
    Left,
    Right
}

public class Room {
    public String number;
    public String description;
    public int x;
    public int y;

    // Regular initializer
    public Room(String number, String description, int x, int y) {
        this.number = number;
        this.description = description;
        this.x = x;
        this.y = y;
    }
}