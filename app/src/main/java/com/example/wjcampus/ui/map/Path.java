package com.example.wjcampus.ui.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Path {

    public static Hashtable<String, Room> MainFloor = Floors.getFloor(1);

    public static Map<String, Map<String, List<Direction>>> cachedRoutes = new HashMap<>();

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
        return !((tops > 1 && lefts > 1) || (lefts > 1 && rights > 1) || (rights > 1 && lefts > 1) || (tops > 1 && bottoms > 1) || (bottoms > 1 && tops > 1));
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

    private static Direction[] travelTo(int x, int y, int destX, int destY, boolean reverse) {
        Direction directionTo;
        int steps = 0;
        if (x > destX) {
            directionTo = reverse ? Direction.Right : Direction.Left;
            steps = x - destX;
        } else {
            directionTo = reverse ? Direction.Left : Direction.Right;
            steps = destX - x ;
        }
        Direction[] xPath = new Direction[steps];
        Arrays.fill(xPath, directionTo);
        if (y > destY) {
            directionTo = reverse ? Direction.Top : Direction.Bottom;
            steps = y - destY;
        } else {
            directionTo = reverse ? Direction.Bottom : Direction.Top;
            steps = destY - y;
        }
        Direction[] yPath = new Direction[steps];
        Arrays.fill(yPath, directionTo);

        Direction[] path = new Direction[xPath.length + yPath.length];
        System.arraycopy(xPath, 0, path, 0, xPath.length);
        System.arraycopy(yPath, 0, path, xPath.length, yPath.length);
        return path;
    }

    private static List<Direction> checkBetween(int startX, int startY, int destX, int destY, List<List<Direction>> paths, String[][] floor, int jumps, JunctionNode[] floorNodes) {
        boolean nearY = startY - 2 < destY && destY < startY+2;
        boolean nearX = startX - 2 < destX && destX < startX+2;
        if(nearX && nearY) {
            return Arrays.asList(travelTo(startX, startY, destX, destY, false));
        }


        ArrayList<JunctionNode> possibleNodes = JunctionNode.findPossibleNodes(startX, startY, floorNodes);

        for (JunctionNode node : possibleNodes) {
            if(nearX && ((startY < destY && destY < node.getY()) || (startY > destY && destY > node.getY()))) {
                return Arrays.asList(travelTo(startX, startY, destX, destY, false));
            }
            if(nearY && ((startX > destX && destX > node.getX()) || (startX < destX && destX < node.getX()))) {
                return Arrays.asList(travelTo(startX, startY, destX, destY, false));
            }
            List<Direction> pathToNode = Arrays.asList(node.travelTo(startX,startY,true));
            Direction ignoreDir = pathToNode.get(0);
            List<Direction> remainingPath = shortestPath(node.getX(), node.getY(), destX, destY, ignoreDir, floor, node, jumps+1, floorNodes);

            List<Direction> completePath = new ArrayList<Direction>();
            completePath.addAll(pathToNode);
            completePath.addAll(remainingPath);
            if(checkRepetition(completePath)) {
                return completePath;
            }
            paths.add(completePath);
        }
        return null;
    }

    private static List<Direction> checkBetween(JunctionNode currNode, int destX, int destY, JunctionNode[] allNodes) {
        int startX = currNode.getX();
        int startY = currNode.getY();

        boolean nearY = startY - 2 < destY && destY < startY+2;
        boolean nearX = startX - 2 < destX && destX < startX+2;
        if(nearX && nearY) {
            return Arrays.asList(currNode.travelTo(destX, destY, false));
        }

        JunctionNode[] possibleNodes = currNode.getNodes();

        for (JunctionNode node : possibleNodes) {
            if(node == null) continue;
            if(nearX && ((startY < destY && destY < node.getY()) || (startY > destY && destY > node.getY()))) {
                return Arrays.asList(currNode.travelTo(destX, destY, false));
            }
            if(nearY && ((startX > destX && destX > node.getX()) || (startX < destX && destX < node.getX()))) {
                return Arrays.asList(currNode.travelTo(destX, destY, false));
            }
            if((nearY && (destX > startX-8 && destX < startX+8)) || (nearX && (destY > startY-8 && destY < startY+8))) {
                return Arrays.asList(currNode.travelTo(destX, destY, false));
            }
        }
        return null;
    }

    private static List<Direction> shortestPath(int startX, int startY, int destX, int destY, Direction ignoreDir, String[][] floor, JunctionNode currNode, int jumps, JunctionNode[] floorNodes) {

        if(jumps > 15) {
            return null;
        }

        List<List<Direction>> paths = new ArrayList<>();
        List<Direction> allDirections = new ArrayList<>(Arrays.asList(Direction.values()));
        DirectionComparator comparator = new DirectionComparator(startX, startY, destX, destY, floor);
        allDirections.sort(comparator);

        if (currNode == null) {
            List<Direction> results = checkBetween(startX,startY, destX, destY, paths, floor, jumps, floorNodes);
            if(results != null) {
                return results;
            }
        } else {


            int ignoreIndex = dirToInt(ignoreDir);
            ignoreIndex = ignoreIndex > 1 ? ignoreIndex - 2 : ignoreIndex + 2;

            JunctionNode[] connections = currNode.getNodes();
            for (Direction direction : allDirections) {
                int dirIndex = dirToInt(direction);

                if (dirIndex == ignoreIndex) {
                    continue;
                }

                JunctionNode destNode = connections[dirIndex];

                List<Direction> results = checkBetween(currNode, destX, destY, floorNodes);
                if (results != null) {
                    return results;
                }
                if (destNode == null) {
                    continue;
                }
                List<Direction> pathToNode = Arrays.asList(currNode.travelTo(destNode));
                ignoreDir = pathToNode.get(0);
                List<Direction> remainingPath = shortestPath(destNode.getX(), destNode.getY(), destX, destY, ignoreDir, floor, destNode, jumps + 1, floorNodes);
                if(remainingPath == null) {
                    continue;
                }
                List<Direction> completePath = new ArrayList<>();
                completePath.addAll(pathToNode);
                completePath.addAll(remainingPath);
                if(checkRepetition(completePath)) {
                    return completePath;
                }
                paths.add(completePath);
            }
        }

        List<List<Direction>> filterPath = paths.stream().filter(pathList -> !pathList.isEmpty()).collect(Collectors.toList());
        filterPath = filterPath.stream().filter(Objects::nonNull).collect(Collectors.toList());

        List<Direction> shortPath = getShortestPath(filterPath);

        return shortPath.size() > 0 ? shortPath : null;
    }

    private static int dirToInt(Direction direction) {
        switch (direction) {
            case Top:
                return 0;
            case Right:
                return 1;
            case Bottom:
                return 2;
            case Left:
                return 3;
        }
        return 5;
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
                possibleStairs = new ArrayList<>(Arrays.asList("Stair 3", "Stair 4", "Stair 5", "Stair 6", "Stair 8"));
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

            double startDistance = Math.sqrt(Math.pow(startStairs.x - start.x, 2)
                    + Math.pow(startStairs.y - start.y, 2));
            double destDistance = Math.sqrt(Math.pow(destStairs.x - dest.x, 2)
                    + Math.pow(destStairs.y - dest.y, 2));

            if (startDistance + destDistance < closestDistance) {
                closestDistance = startDistance + destDistance;
                closestStair = stairsKey;
            }
        }
        return Floors.getFloor(startFloor).get(closestStair);
    }

    private static PathResults shortestSameFloorPath(Room start, Room destination, int floorNumber) {
        String[][] floor = SchoolMap.getFloorMap(floorNumber);
        JunctionNode[] floorNodes = JunctionNode.SchoolJunctions(floorNumber);
        int startX = start.x;
        int startY = 64 - start.y;

        int destX = destination.x;
        int destY = 64 - destination.y;

        if (cachedRoutes.containsKey(start.number) && cachedRoutes.get(start.number).containsKey(destination.number)) {
            List<Direction> path = cachedRoutes.get(start.number).get(destination.number);
            return new PathResults(path, startX, startY, floorNumber);
        } else {
            List<Direction> path = shortestPath(startX, startY, destX, destY, null, floor, null, 0, floorNodes);
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
