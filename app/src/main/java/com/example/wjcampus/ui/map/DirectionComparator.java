package com.example.wjcampus.ui.map;

import java.util.Comparator;

public class DirectionComparator implements Comparator<Direction> {

    private final int currX;
    private final int currY;
    private final int destX;
    private final int destY;
    private final String[][] floor;

    public DirectionComparator(int currX, int currY, int destX, int destY,  String[][] floor) {
        this.currX = currX;
        this.currY = currY;
        this.destX = destX;
        this.destY = destY;
        this.floor = floor;
    }

    @Override
    public int compare(Direction dirOne, Direction dirTwo) {
        // Implement your custom comparison logic here
        double val1 = heuristicValue(dirOne, floor);
        double val2 = heuristicValue(dirTwo, floor);

        return Double.compare(val1, val2);
    }

    private double heuristicValue(Direction direction, String[][] floor) {
        int[] delta = getDirectionDelta(direction);
        int x = delta[0];
        int y = delta[1];

        if((y < 0 || x < 0 || y > 63 || x > 159) || floor[y][x] != ".") {
            return 200;
        }

        return Math.sqrt(Math.pow(destX - x, 2) + Math.pow(destY - y, 2));
    }

    private int[] getDirectionDelta(Direction direction) {
        int[] delta = {currX, currY};
        switch (direction) {
            case Top:
                delta[1] -= 1;
                break;
            case Bottom:
                delta[1] += 1;
                break;
            case Left:
                delta[0] -= 1;
                break;
            case Right:
                delta[0] += 1;
                break;
        }
        return delta;
    }
}