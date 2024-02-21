package com.example.wjcampus.ui.map;
import java.util.ArrayList;
import java.util.Arrays;

public class JunctionNode {
    private JunctionNode[] connections; //Index 0: Top, 1: Right, 2: Down, 3: Left
    private int x;
    private int y;

    public JunctionNode(int posX, int posY) {
        connections = new JunctionNode[4];
        x = posX;
        y = posY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JunctionNode[] getNodes() {
        return connections;
    }

    public void connectNodes(JunctionNode dest, int direction) {
        connections[direction] = dest;
        int newDirection = direction > 1 ? direction-2 : direction+2;
        dest.getNodes()[newDirection] = this;
    }

    //Returns the path to get to the dest junction, or null if dest junction is not connected to this node
    public Direction[] travelTo(JunctionNode dest) {
        for(int i = 0; i < connections.length; i++) {
            if(connections[i] == null || connections[i] != dest)  continue;
            Direction directionTo;
            int steps = 0;
            switch (i) {
                case 0:
                    directionTo = Direction.Top;
                    steps = y - dest.getY();
                    break;
                case 1:
                    directionTo = Direction.Right;
                    steps = dest.getX() - x;
                    break;
                case 2:
                    directionTo = Direction.Bottom;
                    steps = dest.getY() - y;
                    break;
                default:
                    directionTo = Direction.Left;
                    steps = x - dest.getX();
                    break;
            }
            Direction[] path = new Direction[Math.abs(steps)];
            Arrays.fill(path, directionTo);
            return path;
        }
        return null;
    }

    public Direction[] travelTo(int destX, int destY, boolean reverse) {
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
        if (y < destY) {
            directionTo = reverse ? Direction.Top : Direction.Bottom;
            steps = destY - y;
        } else {
            directionTo = reverse ? Direction.Bottom : Direction.Top;
            steps = y - destY;
        }
        Direction[] yPath = new Direction[steps];
        Arrays.fill(yPath, directionTo);

        Direction[] path = new Direction[xPath.length + yPath.length];
        System.arraycopy(xPath, 0, path, 0, xPath.length);
        System.arraycopy(yPath, 0, path, xPath.length, yPath.length);
        return path;

    }

    static ArrayList<JunctionNode> findPossibleNodes(int x, int y, JunctionNode[] nodes) {
        ArrayList<JunctionNode> possibleNodes = new ArrayList<JunctionNode>();
        int closestDistance = 10000;
        JunctionNode closestNode = null;
        for (JunctionNode node : nodes) {
            boolean nearX = (x - 2 < node.getX() && node.getX() < x+2);
            boolean nearY = (y - 2 < node.getY() && node.getY() < y+2);
            if(!nearY && !nearX) continue;

            JunctionNode matchNode = node.getNodes()[1];
            if(nearY) {
                if(matchNode != null && (x > node.getX() && x < matchNode.getX())) {
                    possibleNodes.add(node);
                    continue;
                }
                matchNode = node.getNodes()[3];
                if(matchNode != null && (x < node.getX() && x > matchNode.getX())) {
                    possibleNodes.add(node);;
                    continue;
                }
            }
            if(nearX) {
                matchNode = node.getNodes()[0];
                if(matchNode != null && (y < node.getY() && y > matchNode.getY())) {
                    possibleNodes.add(node);
                    continue;
                }
                matchNode = node.getNodes()[2];
                if(matchNode != null && (y > node.getY() && y < matchNode.getY())) {
                    possibleNodes.add(node);
                    continue;
                }
            }
            int distance = (int)(Math.pow(node.getX() - x, 2) + Math.pow(node.getY() - y, 2));
            if(distance <= closestDistance) {
                closestNode = node;
                closestDistance = distance;
            }
        }

        if(possibleNodes.size() == 0) {
            possibleNodes.add(closestNode);
        }

        return possibleNodes;
    }

    static JunctionNode[] SchoolJunctions(int floor) {
        switch (floor) {
            case 0:
                return BasementFloorJunctions();
            case 1:
                return MainFloorJunctions();
            default:
                return SecondFloorJunctions();
        }
    }

    static JunctionNode[] MainFloorJunctions() {
        JunctionNode[] nodes = new JunctionNode[23];
        nodes[0] = new JunctionNode(14, 63-14);
        nodes[1] = new JunctionNode(14, 63-38);
        nodes[2] = new JunctionNode(14, 63-56);
        nodes[3] = new JunctionNode(33, 63-56);
        nodes[4] = new JunctionNode(33, 63-51);
        nodes[5] = new JunctionNode(36, 63-51);
        nodes[6] = new JunctionNode(36, 63-38);
        nodes[7] = new JunctionNode(44, 63-14);
        nodes[8] = new JunctionNode(44, 63-20);
        nodes[9] = new JunctionNode(51, 63-14);
        nodes[10] = new JunctionNode(51, 63-20);
        nodes[11] = new JunctionNode(51, 63-38);
        nodes[12] = new JunctionNode(79, 63-38);
        nodes[13] = new JunctionNode(79, 63-50);
        nodes[14] = new JunctionNode(83, 63-14);
        nodes[15] = new JunctionNode(83, 63-38);
        nodes[16] = new JunctionNode(115, 63-14);
        nodes[17] = new JunctionNode(115, 63-18);
        nodes[18] = new JunctionNode(115, 63-38);
        nodes[19] = new JunctionNode(123, 63-12);
        nodes[20] = new JunctionNode(123, 63-18);
        nodes[21] = new JunctionNode(130, 63-12);
        nodes[22] = new JunctionNode(130, 63-18);

        nodes[0].connectNodes(nodes[1], 0);
        nodes[0].connectNodes(nodes[7], 1);

        nodes[1].connectNodes(nodes[2], 0);
        nodes[1].connectNodes(nodes[6], 1);

        nodes[2].connectNodes(nodes[3], 1);

        nodes[3].connectNodes(nodes[4], 2);

        nodes[4].connectNodes(nodes[5], 1);

        nodes[5].connectNodes(nodes[6], 2);

        nodes[6].connectNodes(nodes[11], 1);

        nodes[7].connectNodes(nodes[8], 0);
        nodes[7].connectNodes(nodes[9], 1);

        nodes[8].connectNodes(nodes[10], 1);

        nodes[9].connectNodes(nodes[10], 0);
        nodes[9].connectNodes(nodes[14], 1);

        nodes[10].connectNodes(nodes[11], 0);

        nodes[11].connectNodes(nodes[12], 1);

        nodes[12].connectNodes(nodes[13], 0);
        nodes[12].connectNodes(nodes[15], 1);

        nodes[14].connectNodes(nodes[15], 0);
        nodes[14].connectNodes(nodes[16], 1);

        nodes[15].connectNodes(nodes[18], 1);

        nodes[16].connectNodes(nodes[17], 0);

        nodes[17].connectNodes(nodes[18], 0);
        nodes[17].connectNodes(nodes[20], 1);

        nodes[19].connectNodes(nodes[20], 0);
        nodes[19].connectNodes(nodes[21], 1);

        nodes[20].connectNodes(nodes[22], 1);

        nodes[21].connectNodes(nodes[22], 0);
        return nodes;
    }

    static JunctionNode[] SecondFloorJunctions() {
        JunctionNode[] nodes = new JunctionNode[14];
        nodes[0] = new JunctionNode(14, 63-14);
        nodes[1] = new JunctionNode(14, 63-38);
        nodes[2] = new JunctionNode(14, 63-58);
        nodes[3] = new JunctionNode(33, 63-58);
        nodes[4] = new JunctionNode(33, 63-51);
        nodes[5] = new JunctionNode(36, 63-51);
        nodes[6] = new JunctionNode(36, 63-38);
        nodes[7] = new JunctionNode(51, 63-14);
        nodes[8] = new JunctionNode(51, 63-38);
        nodes[9] = new JunctionNode(79, 63-38);
        nodes[10] = new JunctionNode(79, 63-50);
        nodes[11] = new JunctionNode(83, 63-14);
        nodes[12] = new JunctionNode(83, 63-38);

        nodes[13] = new JunctionNode(51, 63-7);

        nodes[0].connectNodes(nodes[1], 0);
        nodes[0].connectNodes(nodes[7], 1);

        nodes[1].connectNodes(nodes[2], 0);
        nodes[1].connectNodes(nodes[6], 1);

        nodes[2].connectNodes(nodes[3], 1);

        nodes[3].connectNodes(nodes[4], 2);

        nodes[4].connectNodes(nodes[5], 1);

        nodes[5].connectNodes(nodes[6], 2);

        nodes[6].connectNodes(nodes[8], 1);

        nodes[7].connectNodes(nodes[8], 0);
        nodes[7].connectNodes(nodes[11], 1);
        nodes[7].connectNodes(nodes[13], 2);

        nodes[10].connectNodes(nodes[8], 0);

        nodes[8].connectNodes(nodes[9], 1);

        nodes[9].connectNodes(nodes[10], 0);
        nodes[9].connectNodes(nodes[12], 1);

        nodes[11].connectNodes(nodes[12], 0);
        return nodes;
    }

    static JunctionNode[] BasementFloorJunctions() {
        JunctionNode[] nodes = new JunctionNode[14];
        nodes[0] = new JunctionNode(14, 63-14);
        nodes[1] = new JunctionNode(14, 63-38);
        nodes[2] = new JunctionNode(14, 63-56);
        nodes[3] = new JunctionNode(33, 63-56);
        nodes[4] = new JunctionNode(33, 63-51);
        nodes[5] = new JunctionNode(36, 63-51);
        nodes[6] = new JunctionNode(36, 63-38);
        nodes[7] = new JunctionNode(40,63-14);
        nodes[8] = new JunctionNode(79, 63-38);
        nodes[9] = new JunctionNode(79, 63-54);
        nodes[10] = new JunctionNode(115, 63-38);
        nodes[11] = new JunctionNode(14, 63-11);
        nodes[12] = new JunctionNode(7, 63-11);
        nodes[13] = new JunctionNode(7, 63-2);

        nodes[0].connectNodes(nodes[1], 0);
        nodes[0].connectNodes(nodes[7], 1);
        nodes[0].connectNodes(nodes[11], 2);

        nodes[1].connectNodes(nodes[2], 0);
        nodes[1].connectNodes(nodes[6], 1);

        nodes[2].connectNodes(nodes[3], 1);

        nodes[3].connectNodes(nodes[4], 2);

        nodes[4].connectNodes(nodes[5], 1);

        nodes[5].connectNodes(nodes[6], 2);

        nodes[6].connectNodes(nodes[8], 1);

        nodes[8].connectNodes(nodes[9], 0);
        nodes[8].connectNodes(nodes[10], 1);

        nodes[11].connectNodes(nodes[12], 3);

        nodes[12].connectNodes(nodes[13], 2);

        return nodes;
    }
}

