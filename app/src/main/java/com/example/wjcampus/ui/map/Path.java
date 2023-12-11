package com.example.wjcampus.ui.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Path {

    public static Hashtable<String, Room> BasementFloor = Floors.getFloor(0);
    public static Hashtable<String, Room> MainFloor = Floors.getFloor(1);
    public static Hashtable<String, Room> SecondFloor = Floors.getFloor(2);


    public static Map<String, Map<String, List<Direction>>> cachedRoutes = new HashMap<>();

    private static int checkPath(int x, int y, Direction direction, String[][] floor) {
        int maxY = floor.length;

        int step = 1;

        if (y < 0 || y >= maxY) {
            return 0;
        }

        int maxX = floor[y].length;
        if (x < 0 || x >= maxX) {
            return 0;
        }

        switch (direction) {
            case Top:
                while (y - step >= 0 && (floor[y - step][x].equals(".") || floor[y - step][x].equals("/"))) {
                    step += 1;
                }
                break;
            case Bottom:
                while (y + step < maxY && (floor[y + step][x].equals(".") || floor[y + step][x].equals("/"))) {
                    step += 1;
                }
                break;
            case Left:
                while (x - step >= 0 && (floor[y][x - step].equals(".") || floor[y][x - step].equals("/"))) {
                    step += 1;
                }
                break;
            case Right:
                while (x + step < maxX && (floor[y][x + step].equals(".") || floor[y][x + step].equals("/"))) {
                    step += 1;
                }
                break;
        }

        return step - 1;
    }

    private static int[] moveIn(int x, int y, Direction direction, int steps) {
        int newX, newY;
        int maxY = 64;
        int maxX = 160;

        switch (direction) {
            case Top:
                newY = y - steps;
                return (newY >= 0 && newY < maxY) ? new int[]{x, newY} : new int[]{-1, -1};
            case Bottom:
                newY = y + steps;
                return (newY >= 0 && newY < maxY) ? new int[]{x, newY} : new int[]{-1, -1};
            case Left:
                newX = x - steps;
                return (newX >= 0 && newX < maxX) ? new int[]{newX, y} : new int[]{-1, -1};
            case Right:
                newX = x + steps;
                return (newX >= 0 && newX < maxX) ? new int[]{newX, y} : new int[]{-1, -1};
        }
        return new int[]{-1, -1};
    }

    private static List<Direction> checkAdjacents(int x, int y, Direction direction, String[][] floor) {
        List<Direction> availableDir = new ArrayList<>();
        switch (direction) {
            case Top:
            case Bottom:
                if (checkPath(x, y, Direction.Left, floor) > 1) {
                    availableDir.add(Direction.Left);
                }
                if (checkPath(x, y, Direction.Right, floor) > 1) {
                    availableDir.add(Direction.Right);
                }
                break;
            case Left:
            case Right:
                if (checkPath(x, y, Direction.Top, floor) > 1) {
                    availableDir.add(Direction.Top);
                }
                if (checkPath(x, y, Direction.Bottom, floor) > 1) {
                    availableDir.add(Direction.Bottom);
                }
                break;
        }
        if (availableDir.size() > 0 && checkPath(x, y, direction, floor) > 1) {
            availableDir.add(direction);
        }
        return availableDir;
    }

    private static boolean isWithinRange(int x, int y, int a, int b) {
        int lowerBound = x - 3;
        int upperBound = x + 3;
        int lowerBoundY = y - 3;
        int upperBoundY = y + 3;
        return (a >= lowerBound && a <= upperBound) && (b >= lowerBoundY && b <= upperBoundY);
    }

    private static boolean checkRepetition(List<Direction> path) {
        int lefts = 0;
        int rights = 0;
        int tops = 0;
        int bottoms = 0;

        for (Direction turn : path) {
            switch (turn) {
                case Top:
                    tops += 1;
                    break;
                case Bottom:
                    bottoms += 1;
                    break;
                case Left:
                    lefts += 1;
                    break;
                case Right:
                    rights += 1;
                    break;
            }
        }
        return !((tops > 1 && lefts > 1) || (lefts > 1 && rights > 0) || (rights > 1 && lefts > 0) || (tops > 1 && bottoms > 0) || (bottoms > 1 && tops > 0));
    }

    private static List<Direction> getShortestPath(List<List<Direction>> paths) {
        if (paths.isEmpty()) {
            return new ArrayList<>();
        }

        List<Direction> shortPath = paths.get(0);

        for (List<Direction> path : paths) {
            if (path.size() < shortPath.size()) {
                shortPath = path;
            }
        }

        return shortPath;
    }

    private static List<Direction> shortestPath(int startX, int startY, int destX, int destY, List<Direction> ignoreDir, int branch, int length, String[][] floor) {
        if ((branch > 6 && length < 0) || (branch > 10 && length < 10)) {
            return null;
        }

        List<List<Direction>> paths = new ArrayList<>();
        List<Direction> allDirections = new ArrayList<>(Arrays.asList(Direction.values()));
        DirectionComparator comparator = new DirectionComparator(startX, startY, destX, destY, floor);

        // if(branch == 0) {
        //     System.out.println(allDirections);
        // }
        allDirections.sort(comparator);
        // if(branch == 0) {
        //     System.out.println(allDirections);
        // }

        for (Direction direction : allDirections) {
            int currX = startX;
            int currY = startY;
            List<Direction> path = new ArrayList<>();

            while (!ignoreDir.stream().anyMatch(dir -> dir == direction) && checkPath(currX, currY, direction, floor) > 0) {
                int[] newCord = moveIn(currX, currY, direction, 1);

                currX = newCord[0];
                currY = newCord[1];
                if (currX < 0 || currY < 0) {
                    break;
                }
                path.add(direction);

                if (isWithinRange(currX, currY, destX, destY)) {
                    paths.add(path);

                    if (checkRepetition(path)) {
                        return path;
                    }
                    break;
                }
                List<Direction> availableDir = checkAdjacents(currX, currY, direction, floor);

                if (availableDir.size() > 0) {

                    DirectionComparator secondComparator = new DirectionComparator(currX, currY, destX, destY, floor);
                    availableDir.sort(secondComparator);

                    for (Direction otherDirection : availableDir) {
                        List<Direction> ignoreDirections = new ArrayList<>(Arrays.asList(Direction.values()));
                        ignoreDirections.removeIf(dir -> dir == otherDirection);

                        int[] newRoute = moveIn(currX, currY, otherDirection, 2);
                        int newX = newRoute[0];
                        int newY = newRoute[1];

                        List<Direction> newRouteList = shortestPath(newX, newY, destX, destY, ignoreDirections, branch + 1, length - path.size() - 2, floor);
                        if (newRouteList != null) {
                            List<Direction> extraPath = new ArrayList<>(path);
                            extraPath.addAll(Arrays.asList(otherDirection, otherDirection));
                            List<Direction> newPath = new ArrayList<>(extraPath);
                            newPath.addAll(newRouteList);

                            if (checkRepetition(newPath) && newPath.size() > extraPath.size()) {
                                return newPath;
                            }
                            paths.add(newPath);
                        }
                    }

                    if (checkPath(currX, currY, direction, floor) > 1) {
                        path.addAll(Arrays.asList(direction, direction));
                        newCord = moveIn(currX, currY, direction, 2);
                        currX = newCord[0];
                        currY = newCord[1];
                    }

                    if (currX < 0 || currY < 0) {
                        break;
                    }
                }
            }
        }

        List<List<Direction>> filterPath = paths.stream().filter(pathList -> !pathList.isEmpty()).collect(Collectors.toList());
        filterPath = filterPath.stream().filter(Objects::nonNull).collect(Collectors.toList());

        List<Direction> shortPath = getShortestPath(filterPath);

        return shortPath.size() > 0 ? shortPath : null;
    }


    private static String dirToString(Direction dir) {
        switch (dir) {
            case Top:
                return "Top";
            case Bottom:
                return "Bottom";
            case Left:
                return "Left";
            case Right:
                return "Right";
        }
        return "ERROR";
    }

    private static void cacheARoute(List<Direction> path, String start, String dest) {
        if (cachedRoutes.containsKey(start)) {
            cachedRoutes.get(start).put(dest, path);
        } else {
            cachedRoutes.put(start, new HashMap<>());
            cacheARoute(path, start, dest);
        }
    }

    private static Room findClosestStairwell(Room start, Room dest, int startFloor, int destFloor) {
        List<String> possibleStairs = new ArrayList<>();


        switch (startFloor) {
            case 0:
                possibleStairs = new ArrayList<>(Arrays.asList("Stair 2", "Stair 3", "Stair 4", "Stair 5", "Stair 6", "Stair 8", "Stair 10"));
                break;
            case 1:
                possibleStairs = new ArrayList<>(Arrays.asList("Stair 3", "Stair 4", "Stair 5", "Stair 6", "Stair 7", "Stair 8"));
                if (destFloor > 1) {
                    possibleStairs.addAll(Arrays.asList("Stair 1", "Stair 9"));
                } else {
                    possibleStairs.addAll(Arrays.asList("Stair 2", "Stair 10"));
                }
                break;
            case 2:
                possibleStairs = new ArrayList<String>(Arrays.asList("Stair 1", "Stair 3", "Stair 4", "Stair 5", "Stair 6", "Stair 8", "Stair 9"));
                break;
            default:
                System.out.println("err");
        }

        String closestStair = "Stair 3";
        double closestDistance = 30000.0;

        for (String stairsKey : possibleStairs) {

            Room startStairs = Floors.getFloor(startFloor).get(stairsKey);
            Room destStairs;
            if(Floors.getFloor(destFloor).containsKey(stairsKey)) {
                destStairs = Floors.getFloor(destFloor).get(stairsKey);
            } else {
                destStairs = startStairs;
            }

            double startDistance = Math.pow(startStairs.entrancesLoc.get(0)[0] - start.entrancesLoc.get(0)[0], 2)
                    + Math.pow(startStairs.entrancesLoc.get(0)[1] - start.entrancesLoc.get(0)[1], 2);
            double destDistance = Math.pow(destStairs.entrancesLoc.get(0)[0] - dest.entrancesLoc.get(0)[0], 2)
                    + Math.pow(destStairs.entrancesLoc.get(0)[1] - dest.entrancesLoc.get(0)[1], 2);

            if (startDistance + destDistance < closestDistance) {
                closestDistance = startDistance + destDistance;
                closestStair = stairsKey;
            }
        }
        return Floors.getFloor(startFloor).get(closestStair);
    }

    private static PathResults shortestSameFloorPath(Room start, Room destination, int floorNumber) {
        String[][] floor = SchoolMap.getFloorMap(floorNumber);

        int startX = start.entrancesLoc.get(0)[0];
        int startY = 64 - start.entrancesLoc.get(0)[1];

        int destX = destination.entrancesLoc.get(0)[0];
        int destY = 64 - destination.entrancesLoc.get(0)[1];

        int maxDist = (int) (Math.sqrt(Math.pow(startX - destX, 2) + Math.pow(startY - destY, 2)) * 1.2);

        if (cachedRoutes.containsKey(start.number) && cachedRoutes.get(start.number).containsKey(destination.number)) {
            List<Direction> path = cachedRoutes.get(start.number).get(destination.number);
            return new PathResults(path, startX, startY, floorNumber);
        } else {
            List<Direction> path = shortestPath(startX, startY, destX, destY, new ArrayList<>(), 0, maxDist, floor);
            cacheARoute(path, start.number, destination.number);
            return new PathResults(path, startX, startY, floorNumber);
        }
    }

    // Find available stairwells, find the closest to both, make a path
    public static List<PathResults> findShortestPath(Room start, int startFloor, Room dest, int destFloor) {
        List<PathResults> paths = new ArrayList<>();

        if (startFloor != destFloor) {
            Room stairs = findClosestStairwell(start, dest, startFloor, destFloor);
            PathResults pathToStairs = shortestSameFloorPath(start, stairs, startFloor);
            paths.add(pathToStairs);

            if (((startFloor == 0 && destFloor == 2) || (startFloor == 2 && destFloor == 0))) {
                if (stairs.number.equals("Stair 2")) {
                    paths.add(shortestSameFloorPath(MainFloor.get("Stair 2"), MainFloor.get("Stair 1"), 1));
                    stairs = MainFloor.get("Stair 1");
                } else if (stairs.number.equals("Stair 1")) {
                    paths.add(shortestSameFloorPath(MainFloor.get("Stair 1"), MainFloor.get("Stair 2"), 1));
                    stairs = MainFloor.get("Stair 2");
                }
            }

            paths.add(shortestSameFloorPath(Floors.getFloor(destFloor).get(stairs.number), dest, destFloor));
            return paths;
        }

        paths.add(shortestSameFloorPath(start, dest, startFloor));
        return paths;
    }

}
