package com.example.wjcampus.ui.map;

import java.util.List;
public class PathResults {
    public List<Direction> directions;
    public int startX;
    public int startY;
    public int floor;

    public PathResults(List<Direction> directions, int startX, int startY, int floor) {
        this.directions = directions;
        this.startX = startX;
        this.startY = startY;
        this.floor = floor;
    }
}
