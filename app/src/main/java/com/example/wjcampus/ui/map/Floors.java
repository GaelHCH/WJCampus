package com.example.wjcampus.ui.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

public class Floors {

    static private Hashtable<String, Room> basementFloor;
    static private Hashtable<String, Room> mainFloor;
    static private Hashtable<String, Room> secondFloor;

    static public Hashtable<String, Room> getFloor(int floorNum) {
        switch (floorNum) {
            case 0:
                if(basementFloor == null) {
                    fillBasement();
                }
                return basementFloor;
            case 1:
                if(mainFloor == null) {
                    fillmain();
                }
                return mainFloor;
            default:
                if(secondFloor == null) {
                    fillsecond();
                }
                return secondFloor;
        }
    }
    static private void fillBasement() {

        basementFloor = new Hashtable<String, Room>();

        basementFloor.put("Court Yard 1", new Room("Court Yard 1", "This is Court Yard 1 in the basement", new ArrayList<>(Arrays.asList(new int[]{86, 20, 6, 18}, new int[]{90, 20, 13, 13}, new int[]{101, 20, 12, 5})), new ArrayList<>(Collections.singletonList(new int[]{89, 39}))));
        basementFloor.put("Court Yard 2", new Room("Court Yard 2", "This is Court Yard 2 in the basement", 55, 20, 21, 18, new ArrayList<>(Collections.singletonList(new int[]{65, 39}))));
        basementFloor.put("Court Yard 3", new Room("Court Yard 3", "This is Court Yard 3 in the basement", 16, 22, 21, 11, new ArrayList<>(Collections.singletonList(new int[]{37, 27}))));
        basementFloor.put("Court Yard 4", new Room("Court Yard 4", "This is Court Yard 4 in the basement", 37, 45, 14, 9, new ArrayList<>(Collections.singletonList(new int[]{36, 49}))));
        basementFloor.put("Court Yard 5", new Room("Court Yard 5", "This is Court Yard 5 in the basement", 16, 45, 15, 7, new ArrayList<>(Collections.singletonList(new int[]{15, 48}))));
        basementFloor.put("G01", new Room("G01", "This is room G01 in the basement", 23, 10, 17, 4, new ArrayList<>(Collections.singletonList(new int[]{25, 15}))));
        basementFloor.put("G02", new Room("G02", "This is room G02 in the basement", 29, 16, 9, 6, new ArrayList<>(Collections.singletonList(new int[]{32, 16}))));
        basementFloor.put("G03", new Room("G03", "This is room G03 in the basement", 23, 16, 6, 6, new ArrayList<>(Collections.singletonList(new int[]{27, 16}))));
        basementFloor.put("G05", new Room("G05", "This is room G05 in the basement", 17, 10, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{20, 15}))));
        basementFloor.put("G07", new Room("G07", "This is room G07 in the basement", 16, 16, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{20, 16}))));
        basementFloor.put("G09", new Room("G09", "This is room G09 in the basement", 7, 15, 7, 5, new ArrayList<>(Collections.singletonList(new int[]{14, 17}))));
        basementFloor.put("G10", new Room("G10", "This is room G10 in the basement", 7, 20, 7, 5, new ArrayList<>(Collections.singletonList(new int[]{14, 22}))));
        basementFloor.put("G11", new Room("G11", "This is room G11 in the basement", 7, 25, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 27}))));
        basementFloor.put("G12", new Room("G12", "This is room G12 in the basement", 7, 28, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 30}))));
        basementFloor.put("G13", new Room("G13", "This is room G13 in the basement", 7, 32, 7, 5, new ArrayList<>(Collections.singletonList(new int[]{14, 34}))));
        basementFloor.put("G14", new Room("G14", "This is room G14 in the basement", 7, 37, 7, 5, new ArrayList<>(Collections.singletonList(new int[]{14, 39}))));
        basementFloor.put("G20", new Room("G20", "This is room G20 in the basement", 16, 52, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{16, 57}))));
        basementFloor.put("G21", new Room("G21", "This is room G21 in the basement", 23, 52, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{26, 57}))));
        basementFloor.put("G22", new Room("G22", "This is room G22 in the basement", 29, 52, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{31, 57}))));
        basementFloor.put("G25", new Room("G25", "This is room G25 in the basement", 31, 49, 4, 3, new ArrayList<>(Collections.singletonList(new int[]{35, 51}))));
        basementFloor.put("G27", new Room("G27", "This is room G27 in the basement", 31, 45, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{35, 47}))));
        basementFloor.put("G30", new Room("G30", "This is room G30 in the basement", 16, 40, 3, 5, new ArrayList<>(Collections.singletonList(new int[]{19, 40}))));
        basementFloor.put("G31", new Room("G31", "This is room G31 in the basement", 16, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{18, 39}))));
        basementFloor.put("G32", new Room("G32", "This is room G32 in the basement", 19, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{21, 40}))));
        basementFloor.put("G33", new Room("G33", "This is room G33 in the basement", 21, 33, 6, 5, new ArrayList<>(Collections.singletonList(new int[]{23, 39}))));
        basementFloor.put("G34", new Room("G34", "This is room G34 in the basement", 24, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{27, 40}))));
        basementFloor.put("G35", new Room("G35", "This is room G35 in the basement", 27, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{39, 39}))));
        basementFloor.put("G36", new Room("G36", "This is room G36 in the basement", 28, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{30, 40}))));
        basementFloor.put("G37", new Room("G37", "This is room G37 in the basement", 32, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{34, 39}))));
        basementFloor.put("G38", new Room("G38", "This is room G38 in the basement", 33, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{34, 40}))));
        basementFloor.put("G39", new Room("G39", "This is room G39 in the basement", 37, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{39, 39}))));
        basementFloor.put("G40", new Room("G40", "This is room G40 in the basement", 37, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{38, 40}))));
        basementFloor.put("G41", new Room("G41", "This is room G41 in the basement", 41, 33, 3, 5, new ArrayList<>(Collections.singletonList(new int[]{42, 39}))));
        basementFloor.put("G42", new Room("G42", "This is room G42 in the basement", 44, 33, 3, 5, new ArrayList<>(Collections.singletonList(new int[]{45, 39}))));
        basementFloor.put("G43", new Room("G43", "This is room G43 in the basement", 41, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{43, 40}))));
        basementFloor.put("G44", new Room("G44", "This is room G44 in the basement", 45, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{47, 40}))));
        basementFloor.put("G45", new Room("G45", "This is room G45 in the basement", 47, 28, 9, 10, new ArrayList<>(Collections.singletonList(new int[]{53, 39}))));
        basementFloor.put("G51", new Room("G51", "This is room G51 in the basement", 36, 54, 15, 10, new ArrayList<>(Collections.singletonList(new int[]{35, 57}))));
        basementFloor.put("G64", new Room("G64", "This is room G64 in the basement", 76, 55, 7, 7, new ArrayList<>(Collections.singletonList(new int[]{79, 55}))));
        basementFloor.put("G66", new Room("G66", "This is room G66 in the basement", 66, 51, 11, 5, new ArrayList<>(Collections.singletonList(new int[]{77, 53}))));
        basementFloor.put("G71", new Room("G71", "This is room G71 in the basement", 72, 40, 5, 3, new ArrayList<>(Collections.singletonList(new int[]{77, 42}))));
        basementFloor.put("G74", new Room("G74", "This is room G74 in the basement", 76, 32, 6, 6, new ArrayList<>(Collections.singletonList(new int[]{79, 39}))));
        basementFloor.put("G77", new Room("G77", "This is room G77 in the basement", 81, 32, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{83, 39}))));
        basementFloor.put("G82", new Room("G82", "This is room G82 in the basement", 91, 32, 10, 6, new ArrayList<>(Collections.singletonList(new int[]{96, 39}))));
        basementFloor.put("G83", new Room("G83", "This is room G83 in the basement", 91, 43, 6, 9, new ArrayList<>(Collections.singletonList(new int[]{96, 43}))));
        basementFloor.put("G84", new Room("G84", "This is room G84 in the basement", 97, 43, 6, 9, new ArrayList<>(Collections.singletonList(new int[]{97, 43}))));
        basementFloor.put("G85", new Room("G85", "This is room G85 in the basement", 98, 40, 5, 3, new ArrayList<>(Collections.singletonList(new int[]{97, 41}))));
        basementFloor.put("G86", new Room("G86", "This is room G86 in the basement", 103, 40, 6, 10, new ArrayList<>(Collections.singletonList(new int[]{106, 40}))));
        basementFloor.put("G87", new Room("G87", "This is room G87 in the basement", 108, 40, 6, 10, new ArrayList<>(Collections.singletonList(new int[]{110, 40}))));
        basementFloor.put("P1", new Room("P1", "This is room P1 in the portables", 0, 0, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{5, 2}))));
        basementFloor.put("P2", new Room("P2", "This is room P2 in the portables", 0, 4, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{5, 6}))));
        basementFloor.put("P3", new Room("P3", "This is room P3 in the portables", 0, 8, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{5, 10}))));
        basementFloor.put("Stair 10", new Room("Stair 10", "This stairway leads down to the art wing", 113, 40, 8, 8, new ArrayList<>(Collections.singletonList(new int[]{115, 40}))));
        basementFloor.put("Stair 2", new Room("Stair 2", "This stairway leads down and is behind the main stairwell", 37, 16, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{39, 16}))));
        basementFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 13, 10, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{15, 15}))));
        basementFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 7, 42, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 45}))));
        basementFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 31, 60, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{34, 60}))));
        basementFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 49, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{50, 40}))));
        basementFloor.put("Stair 7", new Room("Stair 7", "IDK", 56, 52, 3, 4, new ArrayList<>(Collections.singletonList(new int[]{57, 56}))));
        basementFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 45, 8, 8, new ArrayList<>(Collections.singletonList(new int[]{83, 54}))));
    }

    static private void fillmain() {

        mainFloor = new Hashtable<String, Room>();

        mainFloor.put("101", new Room("101", "This is room 101 in the main floor", 44, 16, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{47, 16}))));
        mainFloor.put("102", new Room("102", "This is room 102 in the main floor", 37, 21, 8, 13, new ArrayList<>(Collections.singletonList(new int[]{43, 21}))));
        mainFloor.put("104", new Room("104", "This is room 104 in the main floor", 34, 10, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{37, 15}))));
        mainFloor.put("105", new Room("105", "This is room 105 in the main floor", 32, 16, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{34, 16}))));
        mainFloor.put("106", new Room("106", "This is room 106 in the main floor", 29, 10, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{32, 15}))));
        mainFloor.put("107", new Room("107", "This is room 107 in the main floor", 27, 16, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{29, 16}))));
        mainFloor.put("108", new Room("108", "This is room 108 in the main floor", 23, 10, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{26, 15}))));
        mainFloor.put("109", new Room("109", "This is room 109 in the main floor", 22, 16, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{24, 16}))));
        mainFloor.put("110", new Room("110", "This is room 110 in the main floor", 17, 10, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{20, 15}))));
        mainFloor.put("111", new Room("111", "This is room 111 in the main floor", 16, 16, 6, 6, new ArrayList<>(Collections.singletonList(new int[]{19, 16}))));
        mainFloor.put("113", new Room("113", "This is room 113 in the main floor", 7, 14, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 17}))));
        mainFloor.put("114", new Room("114", "This is room 114 in the main floor", 7, 20, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 22}))));
        mainFloor.put("115", new Room("115", "This is room 115 in the main floor", 7, 24, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 26}))));
        mainFloor.put("116", new Room("116", "This is room 116 in the main floor", 7, 28, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 30}))));
        mainFloor.put("117", new Room("117", "This is room 117 in the main floor", 7, 32, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{14, 24}))));
        mainFloor.put("118", new Room("118", "This is room 118 in the main floor", 7, 36, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 39}))));
        mainFloor.put("121", new Room("121", "This is room 121 in the main floor", 16, 52, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{18, 56}))));
        mainFloor.put("122", new Room("122", "This is room 122 in the main floor", 21, 52, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{23, 56}))));
        mainFloor.put("123", new Room("123", "This is room 123 in the main floor", 27, 52, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{29, 56}))));
        mainFloor.put("124", new Room("124", "This is room 124 in the main floor", 27, 58, 3, 3, new ArrayList<>(Collections.singletonList(new int[]{28, 58}))));
        mainFloor.put("125", new Room("125", "This is room 125 in the main floor", 30, 58, 3, 3, new ArrayList<>(Collections.singletonList(new int[]{31, 58}))));
        mainFloor.put("126", new Room("126", "This is room 126 in the main floor", 31, 52, 3, 4, new ArrayList<>(Collections.singletonList(new int[]{34, 54}))));
        mainFloor.put("127", new Room("127", "This is room 127 in the main floor", 31, 49, 4, 3, new ArrayList<>(Collections.singletonList(new int[]{34, 53}))));
        mainFloor.put("128", new Room("128", "This is room 128 in the main floor", 31, 45, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{35, 47}))));
        mainFloor.put("129", new Room("129", "This is room 129 in the main floor", 16, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{17, 40}))));
        mainFloor.put("130", new Room("130", "This is room 130 in the main floor", 16, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{18, 39}))));
        mainFloor.put("131", new Room("131", "This is room 131 in the main floor", 18, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{20, 40}))));
        mainFloor.put("132", new Room("132", "This is room 132 in the main floor", 21, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{23, 39}))));
        mainFloor.put("133", new Room("133", "This is room 133 in the main floor", 23, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{25, 40}))));
        mainFloor.put("134", new Room("134", "This is room 134 in the main floor", 26, 33, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{28, 39}))));
        mainFloor.put("135", new Room("135", "This is room 135 in the main floor", 28, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{30, 40}))));
        mainFloor.put("136", new Room("136", "This is room 136 in the main floor", 31, 33, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{33, 39}))));
        mainFloor.put("137", new Room("137", "This is room 137 in the main floor", 33, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{34, 40}))));
        mainFloor.put("138", new Room("138", "This is room 138 in the main floor", 35, 33, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{37, 39}))));
        mainFloor.put("140", new Room("140", "This is room 140 in the main floor", 37, 40, 3, 5, new ArrayList<>(Collections.singletonList(new int[]{38, 40}))));
        mainFloor.put("141", new Room("141", "This is room 141 in the main floor", 40, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{42, 40}))));
        mainFloor.put("142", new Room("142", "This is room 142 in the main floor", 44, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{47, 40}))));
        mainFloor.put("143", new Room("143", "This is room 143 in the main floor", 51, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{53, 40}))));
        mainFloor.put("144", new Room("144", "This is room 144 in the main floor", 45, 35, 4, 3, new ArrayList<>(Collections.singletonList(new int[]{47, 39}))));
        mainFloor.put("145", new Room("145", "This is room 145 in the main floor", 51, 32, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{50, 35}))));
        mainFloor.put("146", new Room("146", "This is room 146 in the main floor", 51, 27, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{50, 29}))));
        mainFloor.put("147", new Room("147", "This is room 147 in the main floor", 45, 29, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{49, 32}))));
        mainFloor.put("148", new Room("148", "This is room 148 in the main floor", 45, 23, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{49, 26}))));
        mainFloor.put("149", new Room("149", "This is room 149 in the main floor", 51, 20, 4, 7, new ArrayList<>(Collections.singletonList(new int[]{50, 23}))));
        mainFloor.put("150", new Room("150", "This is room 150 in the main floor", 44, 21, 5, 2, new ArrayList<>(Collections.singletonList(new int[]{49, 22}))));
        mainFloor.put("151", new Room("151", "This is room 151 in the main floor", 63, 8, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{66, 15}))));
        mainFloor.put("153", new Room("153", "This is room 153 in the main floor", 70, 8, 2, 6, new ArrayList<>(Collections.singletonList(new int[]{71, 15}))));
        mainFloor.put("154", new Room("154", "This is room 154 in the main floor also known as the health room", 72, 8, 8, 6, new ArrayList<>(Collections.singletonList(new int[]{76, 15}))));
        mainFloor.put("155", new Room("155", "This is room 155 in the main floor, also used as the counceling room", new ArrayList<>(Arrays.asList(new int[]{51, 16, 29, 4}, new int[]{75, 18, 5, 14})), new ArrayList<>(Collections.singletonList(new int[]{80, 18}))));
        mainFloor.put("156", new Room("156", "This is room 156 in the main floor also known as the college center", 82, 16, 4, 10, new ArrayList<>(Collections.singletonList(new int[]{81, 21}))));
        mainFloor.put("158", new Room("158", "This is room 158 in the main floor", 82, 26, 4, 12, new ArrayList<>(Collections.singletonList(new int[]{81, 32}))));
        mainFloor.put("159", new Room("159", "This is room 159 in the main floor", 76, 32, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{80, 35}))));
        mainFloor.put("160", new Room("160", "This is room 160 in the main floor also known as the library", new ArrayList<>(Arrays.asList(new int[]{87, 0, 21, 14}, new int[]{82, 8, 9, 6}, new int[]{106, 10, 7, 4})), new ArrayList<>(Collections.singletonList(new int[]{91, 15}))));
        mainFloor.put("165", new Room("165", "This is room 165 in the main floor", 86, 16, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{89, 16}))));
        mainFloor.put("166", new Room("166", "This is room 166 in the main floor", 92, 16, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{95, 16}))));
        mainFloor.put("167", new Room("167", "This is room 167 in the main floor", 99, 16, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{101, 16}))));
        mainFloor.put("168", new Room("168", "This is room 168 in the main floor", 106, 16, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{108, 16}))));
        mainFloor.put("169", new Room("169", "This is room 169 in the main floor", 111, 16, 2, 4, new ArrayList<>(Collections.singletonList(new int[]{112, 16}))));
        mainFloor.put("172", new Room("172", "This is room 172 in the main floor also known as the band room", 127, 2, 7, 9, new ArrayList<>(Collections.singletonList(new int[]{130, 12}))));
        mainFloor.put("173", new Room("173", "This is room 173 in the main floor", 124, 7, 3, 4, new ArrayList<>(Collections.singletonList(new int[]{125, 12}))));
        mainFloor.put("174", new Room("174", "This is room 174 in the main floor also known as the choral room", 117, 2, 7, 9, new ArrayList<>(Collections.singletonList(new int[]{121, 12}))));
        mainFloor.put("175", new Room("175", "This is room 175 in the main floor", 117, 11, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{121, 13}))));
        mainFloor.put("190", new Room("190", "This is room 190 in the main floor", 102, 24, 11, 7, new ArrayList<>(Collections.singletonList(new int[]{113, 27}))));
        mainFloor.put("191", new Room("191", "This is room 191 in the main floor", 102, 31, 11, 7, new ArrayList<>(Collections.singletonList(new int[]{113, 34}))));
        mainFloor.put("192", new Room("192", "This is room 192 in the main floor", 97, 32, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{99, 39}))));
        mainFloor.put("193", new Room("193", "This is room 193 in the main floor", 91, 32, 6, 6, new ArrayList<>(Collections.singletonList(new int[]{94, 39}))));
        mainFloor.put("194", new Room("194", "This is room 194 in the main floor", 97, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{99, 40}))));
        mainFloor.put("195", new Room("195", "This is room 195 in the main floor", 92, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{94, 40}))));
        mainFloor.put("196", new Room("196", "This is room 196 in the main floor", 87, 40, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{89, 40}))));
        mainFloor.put("198", new Room("198", "This is room 198 in the main floor", new ArrayList<>(Arrays.asList(new int[]{51, 44, 8, 7}, new int[]{56, 40, 3, 7})), new ArrayList<>(Collections.singletonList(new int[]{111, 38}))));
        mainFloor.put("199", new Room("199", "This is room 199 in the main floor", 59, 40, 17, 16, new ArrayList<>(Collections.singletonList(new int[]{76, 48}))));
        mainFloor.put("Court Yard 1", new Room("Court Yard 1", "This is Court Yard 1 in the main floor", new ArrayList<>(Arrays.asList(new int[]{86, 20, 6, 18}, new int[]{90, 20, 13, 13}, new int[]{101, 20, 12, 5})), new ArrayList<>(Collections.singletonList(new int[]{89, 39}))));
        mainFloor.put("Court Yard 2", new Room("Court Yard 2", "This is Court Yard 2 in the main floor", 55, 20, 21, 18, new ArrayList<>(Collections.singletonList(new int[]{65, 39}))));
        mainFloor.put("Court Yard 3", new Room("Court Yard 3", "This is Court Yard 3 in the main floor", 16, 22, 21, 11, new ArrayList<>(Collections.singletonList(new int[]{37, 27}))));
        mainFloor.put("Court Yard 4", new Room("Court Yard 4", "This is Court Yard 4 in the main floor", 37, 45, 14, 9, new ArrayList<>(Collections.singletonList(new int[]{36, 49}))));
        mainFloor.put("Court Yard 5", new Room("Court Yard 5", "This is Court Yard 5 in the main floor", 16, 45, 15, 7, new ArrayList<>(Collections.singletonList(new int[]{15, 48}))));
        mainFloor.put("Dining", new Room("Dining", "This is the cafeteria in the main floor", 134, 3, 15, 17, new ArrayList<>(Collections.singletonList(new int[]{133, 18}))));
        mainFloor.put("Main Office", new Room("Main Office", "This is the main office in the main floor", new ArrayList<>(Arrays.asList(new int[]{45, 3, 10, 11}, new int[]{53, 8, 10, 6})), new ArrayList<>(Collections.singletonList(new int[]{50, 15}))));
        mainFloor.put("Stair 1", new Room("Stair 1", "This is the main stairway which leads up", 41, 10, 2, 4, new ArrayList<>(Collections.singletonList(new int[]{42, 10}))));
        mainFloor.put("Stair 2", new Room("Stair 2", "This stairway leads down and is behind the main stairwell", 37, 16, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{39, 16}))));
        mainFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 13, 10, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{15, 15}))));
        mainFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 7, 42, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 45}))));
        mainFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 31, 60, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{34, 60}))));
        mainFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 49, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{51, 40}))));
        mainFloor.put("Stair 7", new Room("Stair 7", "IDK", 56, 52, 3, 4, new ArrayList<>(Collections.singletonList(new int[]{57, 56}))));
        mainFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 45, 8, 8, new ArrayList<>(Collections.singletonList(new int[]{83, 54}))));
        mainFloor.put("Stair 9", new Room("Stair 9", "This stairway leads to the top floor and is next to the media center and exit", 82, 3, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{81, 7}))));
        mainFloor.put("Stair 10", new Room("Stair 10", "This stairway leads down to the art wing", 113, 40, 8, 8, new ArrayList<>(Collections.singletonList(new int[]{115, 40}))));
        mainFloor.put("TV Studio", new Room("TV Studio", "This is the TV studioin the main floor", 108, 4, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{113, 7}))));
        mainFloor.put("Auditorium", new Room("Auditorium", "This is the auditorium in the main floor", 116, 20, 33, 20, new ArrayList<>(Collections.singletonList(new int[]{115, 29}))));
    }

    static private void fillsecond() {

        secondFloor = new Hashtable<String, Room>();

        secondFloor.put("200", new Room("200", "This is room 200 in the main floor", 29, 10, 12, 4, new ArrayList<>(Collections.singletonList(new int[]{31, 15}))));
        secondFloor.put("203", new Room("203", "This is room 204 in the main floor", 27, 16, 10, 6, new ArrayList<>(Collections.singletonList(new int[]{29, 16}))));
        secondFloor.put("204", new Room("204", "This is room 204 in the main floor", 17, 10, 12, 4, new ArrayList<>(Collections.singletonList(new int[]{26, 15}))));
        secondFloor.put("205", new Room("205", "This is room 205 in the main floor", 16, 16, 11, 6, new ArrayList<>(Collections.singletonList(new int[]{24, 16}))));
        secondFloor.put("207", new Room("207", "This is room 207 in the main floor", 7, 14, 7, 8, new ArrayList<>(Collections.singletonList(new int[]{14, 15}))));
        secondFloor.put("208", new Room("208", "This is room 208 in the main floor", 7, 22, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 23}))));
        secondFloor.put("209", new Room("209", "This is room 209 in the main floor", 11, 28, 3, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 29}))));
        secondFloor.put("211", new Room("211", "This is room 211 in the main floor", 7, 34, 7, 9, new ArrayList<>(Collections.singletonList(new int[]{14, 41}))));
        secondFloor.put("213", new Room("213", "This is room 213 in the main floor", 16, 52, 8, 5, new ArrayList<>(Collections.singletonList(new int[]{19, 58}))));
        secondFloor.put("214", new Room("214", "This is room 214 in the main floor", 24, 52, 9, 5, new ArrayList<>(Collections.singletonList(new int[]{26, 58}))));
        secondFloor.put("215", new Room("215", "This is room 215 in the main floor", 31, 45, 4, 7, new ArrayList<>(Collections.singletonList(new int[]{35, 51}))));
        secondFloor.put("220", new Room("220", "This is room 220 in the main floor", 16, 33, 10, 5, new ArrayList<>(Collections.singletonList(new int[]{19, 39}))));
        secondFloor.put("221", new Room("221", "This is room 221 in the main floor", 16, 40, 10, 5, new ArrayList<>(Collections.singletonList(new int[]{20, 40}))));
        secondFloor.put("222", new Room("222", "This is room 222 in the main floor", 26, 33, 9, 5, new ArrayList<>(Collections.singletonList(new int[]{33, 39}))));
        secondFloor.put("223", new Room("223", "This is room 223 in the main floor", 26, 40, 9, 5, new ArrayList<>(Collections.singletonList(new int[]{34, 40}))));
        secondFloor.put("224", new Room("224", "This is room 224 in the main floor", 35, 33, 10, 5, new ArrayList<>(Collections.singletonList(new int[]{39, 39}))));
        secondFloor.put("225", new Room("225", "This is room 225 in the main floor", 37, 40, 6, 5, new ArrayList<>(Collections.singletonList(new int[]{40, 40}))));
        secondFloor.put("226", new Room("226", "This is room 226 in the main floor", 43, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{44, 40}))));
        secondFloor.put("227", new Room("227", "This is room 227 in the main floor", 45, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{47, 40}))));
        secondFloor.put("228", new Room("228", "This is room 228 in the main floor", 51, 40, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{52, 40}))));
        secondFloor.put("229", new Room("229", "This is room 229 in the main floor", 45, 32, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{49, 33}))));
        secondFloor.put("230", new Room("230", "This is room 230 in the main floor", 51, 32, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{50, 34}))));
        secondFloor.put("231", new Room("231", "This is room 231 in the main floor", 45, 26, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{49, 31}))));
        secondFloor.put("232", new Room("232", "This is room 232 in the main floor", 51, 26, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{50, 31}))));
        secondFloor.put("233", new Room("233", "This is room 233 in the main floor", 45, 20, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{49, 21}))));
        secondFloor.put("234", new Room("234", "This is room 234 in the main floor", 51, 20, 4, 6, new ArrayList<>(Collections.singletonList(new int[]{50, 21}))));
        secondFloor.put("235", new Room("235", "This is room 235 in the main floor", 51, 18, 5, 2, new ArrayList<>(Collections.singletonList(new int[]{50, 19}))));
        secondFloor.put("236", new Room("236", "This is room 236 in the main floor", 51, 16, 5, 2, new ArrayList<>(Collections.singletonList(new int[]{50, 17}))));
        secondFloor.put("237", new Room("237", "This is room 237 in the main floor", 45, 16, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{49, 17}))));
        secondFloor.put("238", new Room("238", "This is room 238 in the main floor", 45, 9, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{49, 11}))));
        secondFloor.put("239", new Room("239", "This is room 239 in the main floor", 45, 5, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{49, 7}))));
        secondFloor.put("241", new Room("241", "This is room 241 in the main floor", 51, 5, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{50, 7}))));
        secondFloor.put("242", new Room("242", "This is room 242 in the main floor", 51, 9, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{50, 11}))));
        secondFloor.put("243", new Room("243", "This is room 243 in the main floor", 55, 9, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{57, 15}))));
        secondFloor.put("244", new Room("244", "This is room 244 in the main floor", 59, 9, 4, 5, new ArrayList<>(Collections.singletonList(new int[]{61, 15}))));
        secondFloor.put("245", new Room("245", "This is room 245 in the main floor", 56, 16, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{59, 17}))));
        secondFloor.put("246", new Room("246", "This is room 246 in the main floor", 62, 9, 9, 5, new ArrayList<>(Collections.singletonList(new int[]{63, 15}))));
        secondFloor.put("247", new Room("247", "This is room 247 in the main floor", 61, 16, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{62, 16}))));
        secondFloor.put("248", new Room("248", "This is room 248 in the main floor", 67, 16, 6, 4, new ArrayList<>(Collections.singletonList(new int[]{73, 16}))));
        secondFloor.put("249", new Room("249", "This is room 249 in the main floor", 70, 9, 10, 5, new ArrayList<>(Collections.singletonList(new int[]{75, 15}))));
        secondFloor.put("250", new Room("250", "This is room 250 in the main floor", 73, 16, 7, 4, new ArrayList<>(Collections.singletonList(new int[]{76, 16}))));
        secondFloor.put("254", new Room("254", "This is room 254 in the main floor", 82, 16, 4, 13, new ArrayList<>(Collections.singletonList(new int[]{81, 22}))));
        secondFloor.put("255", new Room("255", "This is room 255 in the main floor", 75, 20, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{80, 24}))));
        secondFloor.put("256", new Room("256", "This is room 256 in the main floor", 75, 32, 5, 6, new ArrayList<>(Collections.singletonList(new int[]{80, 35}))));
        secondFloor.put("257", new Room("257", "This is room 257 in the main floor", 75, 26, 5, 7, new ArrayList<>(Collections.singletonList(new int[]{80, 31}))));
        secondFloor.put("258", new Room("258", "This is room 258 in the main floor", 82, 29, 4, 10, new ArrayList<>(Collections.singletonList(new int[]{81, 33}))));
        secondFloor.put("259", new Room("259", "This is room 259 in the main floor", 82, 39, 4, 7, new ArrayList<>(Collections.singletonList(new int[]{81, 40}))));
        secondFloor.put("Stair 1", new Room("Stair 1", "This is the main stairway which leads up", 41, 10, 2, 4, new ArrayList<>(Collections.singletonList(new int[]{42, 15}))));
        secondFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 13, 10, 4, 4, new ArrayList<>(Collections.singletonList(new int[]{15, 15}))));
        secondFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 7, 42, 7, 6, new ArrayList<>(Collections.singletonList(new int[]{14, 45}))));
        secondFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 31, 60, 5, 4, new ArrayList<>(Collections.singletonList(new int[]{34, 60}))));
        secondFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 49, 40, 2, 5, new ArrayList<>(Collections.singletonList(new int[]{50, 40}))));
        secondFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 45, 8, 8, new ArrayList<>(Collections.singletonList(new int[]{83, 54}))));
        secondFloor.put("Stair 9", new Room("Stair 9", "This stairway leads to the top floor and is next to the media center and exit", 82, 3, 5, 5, new ArrayList<>(Collections.singletonList(new int[]{81, 5}))));
    }
}
