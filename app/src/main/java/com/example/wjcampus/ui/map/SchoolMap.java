package com.example.wjcampus.ui.map;

import java.util.List;

public class SchoolMap {
    public static String[][][] map = new String[3][64][160];
    public static String[][][] tempMap = new String[3][64][160];

    // Constructor to initialize the map with 64 rows and 160 columns of "."
    public SchoolMap() {
        map[0] = new String[64][160];
        map[1] = new String[64][160];
        map[2] = new String[64][160];
        for (int i = 0; i < 64; i++) {
            map[0][i] = new String[160];
            map[1][i] = new String[160];
            map[2][i] = new String[160];
            for (int j = 0; j < 160; j++) {
                map[0][i][j] = ".";
                map[1][i][j] = ".";
                map[2][i][j] = ".";
            }
        }

        drawBasementBorder();
        drawMainBorder();
        drawUpperBorder();
        populateFloors();
        cloneMap(map);
    }

    // Prints the 2D array map
    public static String printFloor() {
        StringBuilder results = new StringBuilder();
        int i = 0;

        for (String[][] floor: tempMap) {
            results.append("Floor " + i);
            results.append("\n");
            i++;
            for (String[] y : floor) {
                for (String x : y) {
                    results.append(x);
                }
                results.append("\n");
            }
        }
        return results.toString();
    }

    private static void markSinglePath(List<Direction> path, int x, int y, int floorNum) {
        String[][] floor = tempMap[floorNum];

        int currX = x;
        int currY = y;
        for (Direction move : path) {
            int[] newPosition = moveIn(currX, currY, move, 1);
            currX = newPosition[0];
            currY = newPosition[1];

            String symbol = "@";
            switch (move) {
                case Top:
                    symbol = "^";
                    break;
                case Bottom:
                    symbol = "v";
                    break;
                case Left:
                    symbol = "<";
                    break;
                case Right:
                    symbol = ">";
                    break;
            }
            floor[currY][currX] = symbol;
        }

        tempMap[floorNum] = floor;
    }

    public static void markPaths(List<PathResults> paths) {
        cloneMap(map);

        for (PathResults path : paths) {
            markSinglePath(path.directions, path.startX, path.startY, path.floor);
        }
    }

    public static void cloneMap(String[][][] original) {
        String[][][] clone = new String[original.length][][];

        for (int i = 0; i < original.length; i++) {
            clone[i] = new String[original[i].length][];

            for (int j = 0; j < original[i].length; j++) {
                clone[i][j] = original[i][j].clone();
            }
        }

        tempMap = clone;
    }

    public static String[][] getFloorMap(int floor) {
        return map[floor];
    }

    // Draws wall borders for the main floor
    private void drawMainBorder() {
        // Main office
        drawHorizontalLine(1, 60, 42, 45);
        drawVerticalLine(1, 41, 54, 60);

        // Media Center
        drawHorizontalLine(1, 60, 80, 84);
        drawVerticalLine(1, 79, 56, 60);

        // Studio/Rehearsal
        drawHorizontalLine(1, 60, 112, 116);

        // Top Right
        drawHorizontalLine(1, 23, 101, 112);

        // Top Center
        drawHorizontalLine(1, 23, 79, 89);
        drawVerticalLine(1, 79, 19, 23);

        // Top Center - Stairs
        drawHorizontalLine(1, 8, 76, 87);
        drawVerticalLine(1, 87, 8, 12);

        // Top Left
        drawHorizontalLine(1, 5, 14, 26);
        drawVerticalLine(1, 13, 5, 15);
        drawHorizontalLine(1, 5, 35, 36);
        drawVerticalLine(1, 37, 5, 10);
        drawVerticalLine(1, 35, 3, 5);

        // Music Room
        drawMusicRoom(1, 123, 128, 14, 17);
    }

    // Draws wall borders for the 2nd floor
    private void drawUpperBorder() {
        // Room 2
        drawHorizontalLine(2, 58, 49, 52);

        // Main stairs
        drawHorizontalLine(2, 50, 43, 45);

        // Top Center
        drawHorizontalLine(2, 23, 79, 81);
        drawVerticalLine(2, 79, 19, 23);

        // Top Center - Stairs
        drawHorizontalLine(2, 8, 76, 87);
        drawVerticalLine(2, 87, 8, 12);

        // Top Left
        drawVerticalLine(2, 31, 3, 5);
        drawHorizontalLine(2, 5, 14, 31);
        drawVerticalLine(2, 13, 5, 15);
        drawHorizontalLine(2, 5, 35, 36);
        drawVerticalLine(2, 37, 5, 18);
        drawVerticalLine(2, 35, 3, 5);

        // Bottom Right
        drawVerticalLine(2, 82, 43, 55);
        drawVerticalLine(2, 79, 55, 60);
        drawHorizontalLine(2, 60, 79, 81);

        // Top Right Stairwell
        drawHorizontalLine(2, 23, 55, 75);
        drawVerticalLine(2, 75, 9, 23);
        drawHorizontalLine(2, 47, 37, 44);

        // Courtyard 5
        drawVerticalLine(2, 16, 12, 19);

        // Courtyard 3
        drawVerticalLine(2, 16, 31, 42);

        // Courtyard 2
        drawHorizontalLine(2, 26, 55, 75);
    }


    // Draws wall borders for the basement
    private void drawBasementBorder() {
        // Top Center
        drawHorizontalLine(0, 23, 79, 95);
        drawVerticalLine(0, 95, 21, 23);
        drawVerticalLine(0, 79, 19, 23);

        // Rightest Art Stairs
        drawHorizontalLine(0, 26, 101, 120);
        drawVerticalLine(0, 120, 20, 26);

        // Top Center - Stairs
        drawHorizontalLine(0, 8, 76, 87);
        drawVerticalLine(0, 87, 8, 12);

        // Top Left
        drawVerticalLine(0, 32, 3, 5);
        drawHorizontalLine(0, 5, 14, 31);
        drawVerticalLine(0, 13, 5, 15);
        drawHorizontalLine(0, 5, 35, 36);
        drawVerticalLine(0, 35, 3, 5);

        // Top Right Stairwell
        drawVerticalLine(0, 76, 9, 23);
        drawVerticalLine(0, 41, 48, 50);
        drawHorizontalLine(0, 23, 51, 75);
        map[0][50][40] = "X";

        // Portables
        drawVerticalLine(0, 4, 49, 53);
        drawVerticalLine(0, 7, 50, 63);
        drawVerticalLine(0, 7, 50, 54);
        drawHorizontalLine(0, 48, 4, 6);
        drawHorizontalLine(0, 50, 7, 12);
        drawHorizontalLine(0, 63, 5, 6);
    }

    // Draws a horizontal line on the map
    private void drawHorizontalLine(int floor, int row, int startCol, int endCol) {
        for (int i = startCol; i <= endCol; i++) {
            map[floor][row][i] = "X";
        }
    }

    // Draws a vertical line on the map
    private void drawVerticalLine(int floor, int col, int startRow, int endRow) {
        for (int i = startRow; i <= endRow; i++) {
            map[floor][i][col] = "X";
        }
    }

    // Draws the music room on the map
    private void drawMusicRoom(int floor, int startX, int endX, int startY, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                map[floor][64 - y][x] = "X";
            }
        }
    }

    // Places a room object inside of the map array
    private void placeRoom(Room room, int floorNum) {
        String[][] floor = map[floorNum];

        if (room.shape != null) {
            for (int[] square : room.shape) {
                for (int r = 0; r < square[3]; r++) {
                    for (int c = 0; c < square[2]; c++) {
                        if (63 - square[1] - r >= floor.length || 63 - square[1] - r < 0) {
                            System.out.println("Bottom Y:" + square[2] + " r " + r);
                            System.out.println(room.number);
                            break;
                        }
                        if (square[0] + c >= floor[0].length || square[0] + c < 0) {
                            System.out.println("Left X:" + square[0] + " c " + c);
                            System.out.println(room.number);
                            break;
                        }
                        String icon = "*";
                        if (r == 0 || c == 0 || r + 1 == square[3] || c + 1 == square[2]) {
                            icon = "#";
                        }

                        String currIcon = floor[63 - square[1] - r][square[0] + c];
                        switch (currIcon) {
                            case ".":
                            case "#":
                                floor[63 - square[1] - r][square[0] + c] = icon;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            floor[64 - room.entrancesLoc.get(0)[1]][room.entrancesLoc.get(0)[0]] = "/";
            map[floorNum] = floor;
            return;
        }

        for (int r = 0; r < room.height; r++) {
            for (int c = 0; c < room.width; c++) {
                if (63 - room.bottomY - r >= floor.length || 63 - room.bottomY - r < 0) {
                    System.out.println("Bottom Y:" + room.bottomY + " r " + r);
                    System.out.println(room.number);
                    break;
                }
                if (room.leftX + c >= floor[0].length || room.leftX + c < 0) {
                    System.out.println("Left X:" + room.leftX + " c " + c);
                    System.out.println(room.number);
                    break;
                }

                String icon = "*";
                if (r == 0 || c == 0 || r + 1 == room.height || c + 1 == room.width) {
                    icon = "#";
                }
                floor[63 - room.bottomY - r][room.leftX + c] = icon;
            }
        }

        floor[64 - room.entrancesLoc.get(0)[1]][room.entrancesLoc.get(0)[0]] = "/";
        map[floorNum] = floor;
    }

    public static int[] moveIn(int x, int y, Direction direction, int steps) {
        int[] newPosition = {x, y};
        switch (direction) {
            case Top:
                newPosition[1] -= steps;
                break;
            case Bottom:
                newPosition[1] += steps;
                break;
            case Left:
                newPosition[0] -= steps;
                break;
            case Right:
                newPosition[0] += steps;
                break;
        }
        return newPosition;
    }

    public void populateFloors() {
        for (int i = 0; i < 3; i++) {
            int roomFloor = i;
            Floors.getFloor(roomFloor).values().forEach((room) -> placeRoom(room, roomFloor));
        }
    }

}



