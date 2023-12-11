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
    public int leftX;
    public int bottomY;
    public int width;
    public int height;
    public List<int[]> entrancesLoc; // Shape is used when the room is not a rectangle, shape: [[x1, y1, w1, h1], [x2, y2, w2, h2]]
    public List<int[]> shape;

    // Regular initializer
    public Room(String number, String description, int leftX, int bottomY, int width, int height, List<int[]> entrancesLoc) {
        this.number = number;
        this.description = description;
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
        this.entrancesLoc = entrancesLoc;
    }

    public Room(String number, String description, List<int[]> shape, List<int[]> entrancesLoc) {
        this.number = number;
        this.description = description;
        this.shape = shape;
        this.entrancesLoc = entrancesLoc;
    }
}