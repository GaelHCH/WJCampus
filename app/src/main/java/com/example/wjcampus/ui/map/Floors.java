package com.example.wjcampus.ui.map;

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

        basementFloor.put("Court Yard 3", new Room("Court Yard 3", "This is Court Yard 3 in the basement floor", 14, 21));
        basementFloor.put("Court Yard 4", new Room("Court Yard 4", "This is Court Yard 4 in the basement floor", 36, 51));
        basementFloor.put("Court Yard 5", new Room("Court Yard 5", "This is Court Yard 5 in the basement floor", 14, 45));

        //y=14
        basementFloor.put("G02", new Room("G02", "This is room G02 in the basement", 35, 14));
        basementFloor.put("G03", new Room("G03", "This is room G03 in the basement", 23, 14));
        basementFloor.put("G04", new Room("G04", "This is room G03 in the basement", 25, 14));
        basementFloor.put("G05", new Room("G05", "This is room G05 in the basement", 22, 14));
        basementFloor.put("G07", new Room("G07", "This is room G07 in the basement", 22, 14));

        //x=14
        basementFloor.put("G09", new Room("G09", "This is room G09 in the basement", 14, 14));
        basementFloor.put("G10", new Room("G10", "This is room G10 in the basement", 14, 19));
        basementFloor.put("G11", new Room("G11", "This is room G11 in the basement", 14, 26));
        basementFloor.put("G12", new Room("G12", "This is room G12 in the basement", 14, 27));
        basementFloor.put("G13", new Room("G13", "This is room G13 in the basement", 14, 34));
        basementFloor.put("G14", new Room("G14", "This is room G14 in the basement", 14, 35));

        //y=56
        basementFloor.put("G20", new Room("G20", "This is room G20 in the basement", 20, 56));
        basementFloor.put("G21", new Room("G21", "This is room G21 in the basement", 22, 56));
        basementFloor.put("G22", new Room("G22", "This is room G22 in the basement", 28, 56));


        basementFloor.put("G25", new Room("G25", "This is room G25 in the basement", 33, 51));
        basementFloor.put("G27", new Room("G27", "This is room G27 in the basement", 36, 46));

        //y=38
        basementFloor.put("G30", new Room("G30", "This is room G30 in the basement", 16, 38));
        basementFloor.put("G31", new Room("G31", "This is room G31 in the basement", 20, 38));
        basementFloor.put("G32", new Room("G32", "This is room G32 in the basement", 21, 38));
        basementFloor.put("G33", new Room("G33", "This is room G33 in the basement", 21, 38));
        basementFloor.put("G34", new Room("G34", "This is room G34 in the basement", 24, 38));
        basementFloor.put("G35", new Room("G35", "This is room G35 in the basement", 30, 38));
        basementFloor.put("G36", new Room("G36", "This is room G36 in the basement", 31, 38));
        basementFloor.put("G37", new Room("G37", "This is room G37 in the basement", 32, 38));
        basementFloor.put("G38", new Room("G38", "This is room G38 in the basement", 34, 38));
        basementFloor.put("G39", new Room("G39", "This is room G39 in the basement", 39, 38));
        basementFloor.put("G40", new Room("G40", "This is room G40 in the basement", 41, 38));
        basementFloor.put("G41", new Room("G41", "This is room G41 in the basement", 41, 38));
        basementFloor.put("G42", new Room("G42", "This is room G42 in the basement", 44, 38));
        basementFloor.put("G43", new Room("G43", "This is room G43 in the basement", 44, 38));
        basementFloor.put("G44", new Room("G44", "This is room G44 in the basement", 48, 38));
        basementFloor.put("G45", new Room("G45", "This is room G45 in the basement", 47, 38));
        basementFloor.put("G46", new Room("G46", "This is room G46 in the basement", 54, 38));

        basementFloor.put("G51", new Room("G51", "This is room G51 in the basement", 36, 51));

        //x=79
        basementFloor.put("G64", new Room("G64", "This is room G64 in the basement", 79, 54));
        basementFloor.put("G65", new Room("G65", "This is room G65 in the basement", 79, 52));
        basementFloor.put("G68", new Room("G68", "This is room G68 in the basement", 79, 45));
        basementFloor.put("G69", new Room("G69", "This is room G69 in the basement", 79, 47));
        basementFloor.put("G70", new Room("G70", "This is room G70 in the basement", 79, 44));
        basementFloor.put("G71", new Room("G71", "This is room G71 in the basement", 79, 41));

        //y=38
        basementFloor.put("G74", new Room("G74", "This is room G74 in the basement", 79, 38));
        basementFloor.put("G75", new Room("G75", "This is room G75 in the basement", 85, 38));
        basementFloor.put("G76", new Room("G76", "This is room G76 in the basement", 84, 38));
        basementFloor.put("G77", new Room("G77", "This is room G77 in the basement", 86, 38));
        basementFloor.put("G78", new Room("G78", "This is room G78 in the basement", 84, 38));
        basementFloor.put("G79", new Room("G79", "This is room G79 in the basement", 87, 38));
        basementFloor.put("G82", new Room("G82", "This is room G82 in the basement", 97, 38));

        basementFloor.put("G81", new Room("G81", "This is room G81 in the basement", 96, 38));
        basementFloor.put("G83", new Room("G83", "This is room G83 in the basement", 97, 38));
        basementFloor.put("G84", new Room("G84", "This is room G84 in the basement", 98, 38));
        basementFloor.put("G85", new Room("G85", "This is room G85 in the basement", 99, 38));

        basementFloor.put("G86", new Room("G86", "This is room G86 in the basement", 108, 38));
        basementFloor.put("G87", new Room("G87", "This is room G87 in the basement", 109, 38));

        basementFloor.put("P1", new Room("P1", "This is room P1 in the basement", 7, 2));
        basementFloor.put("P2", new Room("P2", "This is room P2 in the basement", 7, 6));
        basementFloor.put("P3", new Room("P3", "This is room P3 in the basement", 7, 11));

        basementFloor.put("Stair 2", new Room("Stair 2", "This stairway leads down and is behind the main stairwell", 40, 14));
        basementFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 16, 14));
        basementFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 14, 45));
        basementFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 33, 56));
        basementFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 51, 38));
        basementFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 50));
        basementFloor.put("Stair 10", new Room("Stair 10", "This stairway leads down to the art wing", 115, 38));

    }

    static private void fillmain() {

        mainFloor = new Hashtable<String, Room>();
        mainFloor.put("101", new Room("101", "This is room 101 in the main floor", 48, 20));
        mainFloor.put("102", new Room("102", "This is room 102 in the main floor", 44, 20));

        //y=14
        mainFloor.put("104", new Room("104", "This is room 104 in the main floor", 35, 14));
        mainFloor.put("105", new Room("105", "This is room 105 in the main floor", 32, 14));
        mainFloor.put("106", new Room("106", "This is room 106 in the main floor", 34, 14));
        mainFloor.put("107", new Room("107", "This is room 107 in the main floor", 31, 14));
        mainFloor.put("108", new Room("108", "This is room 108 in the main floor", 23, 14));
        mainFloor.put("109", new Room("109", "This is room 109 in the main floor", 22, 14));
        mainFloor.put("110", new Room("110", "This is room 110 in the main floor", 22, 14));
        mainFloor.put("111", new Room("111", "This is room 111 in the main floor", 21, 14));

        //x=14
        mainFloor.put("113", new Room("113", "This is room 113 in the main floor", 14, 14));
        mainFloor.put("114", new Room("114", "This is room 114 in the main floor", 14, 19));
        mainFloor.put("115", new Room("115", "This is room 115 in the main floor", 14, 25));
        mainFloor.put("116", new Room("116", "This is room 116 in the main floor", 14, 26));
        mainFloor.put("117", new Room("117", "This is room 117 in the main floor", 14, 34));
        mainFloor.put("118", new Room("118", "This is room 118 in the main floor", 14, 35));

        //y=56
        mainFloor.put("121", new Room("121", "This is room 121 in the main floor", 20, 56));
        mainFloor.put("122", new Room("122", "This is room 122 in the main floor", 21, 56));
        mainFloor.put("123", new Room("123", "This is room 123 in the main floor", 30, 56));
        mainFloor.put("124", new Room("124", "This is room 124 in the main floor", 30, 56));
        mainFloor.put("125", new Room("125", "This is room 125 in the main floor", 32, 56));

        mainFloor.put("126", new Room("126", "This is room 126 in the main floor", 33, 51));
        mainFloor.put("127", new Room("127", "This is room 127 in the main floor", 33, 51));
        mainFloor.put("128", new Room("128", "This is room 128 in the main floor", 36, 47));

        //y=38
        mainFloor.put("129", new Room("129", "This is room 129 in the main floor", 17, 38));
        mainFloor.put("130", new Room("130", "This is room 130 in the main floor", 20, 38));
        mainFloor.put("131", new Room("131", "This is room 131 in the main floor", 22, 38));
        mainFloor.put("132", new Room("132", "This is room 132 in the main floor", 21, 38));
        mainFloor.put("133", new Room("133", "This is room 133 in the main floor", 23, 38));
        mainFloor.put("134", new Room("134", "This is room 134 in the main floor", 30, 38));
        mainFloor.put("135", new Room("135", "This is room 135 in the main floor", 31, 38));
        mainFloor.put("136", new Room("136", "This is room 136 in the main floor", 31, 38));
        mainFloor.put("137", new Room("137", "This is room 137 in the main floor", 33, 38));
        mainFloor.put("138", new Room("138", "This is room 138 in the main floor", 31, 38));
        mainFloor.put("140", new Room("140", "This is room 140 in the main floor", 39, 38));
        mainFloor.put("141", new Room("141", "This is room 141 in the main floor", 43, 38));
        mainFloor.put("142", new Room("142", "This is room 142 in the main floor", 49, 38));
        mainFloor.put("143", new Room("143", "This is room 143 in the main floor", 53, 38));

        //x=51
        mainFloor.put("144", new Room("144", "This is room 144 in the main floor", 51, 35));
        mainFloor.put("145", new Room("145", "This is room 145 in the main floor", 51, 32));
        mainFloor.put("146", new Room("146", "This is room 146 in the main floor", 51, 31));
        mainFloor.put("147", new Room("147", "This is room 147 in the main floor", 51, 28));
        mainFloor.put("148", new Room("148", "This is room 148 in the main floor", 51, 27));
        mainFloor.put("149", new Room("149", "This is room 149 in the main floor", 51, 25));
        mainFloor.put("150", new Room("150", "This is room 150 in the main floor", 51, 21));

        //y=14
        mainFloor.put("151", new Room("151", "This is room 151 in the main floor", 65, 14));
        mainFloor.put("152", new Room("152", "This is room 152 in the main floor", 66, 14));
        mainFloor.put("153", new Room("153", "This is room 153 in the main floor", 72, 14));
        mainFloor.put("154", new Room("154", "This is room 154 in the main floor also known as the health room", 74, 14));

        //x=83
        mainFloor.put("155", new Room("155", "This is room 155 in the main floor, also used as the counceling room", 83, 18));
        mainFloor.put("156", new Room("156", "This is room 156 in the main floor also known as the college center", 83, 18));
        mainFloor.put("158", new Room("158", "This is room 158 in the main floor", 83, 29));
        mainFloor.put("159", new Room("159", "This is room 159 in the main floor", 83, 34));

        //y=14
        mainFloor.put("160", new Room("160", "This is room 160 in the main floor also known as the library", 92, 14));
        mainFloor.put("165", new Room("165", "This is room 165 in the main floor", 92, 14));
        mainFloor.put("166", new Room("166", "This is room 166 in the main floor", 94, 14));
        mainFloor.put("167", new Room("167", "This is room 167 in the main floor", 104, 14));
        mainFloor.put("168", new Room("168", "This is room 168 in the main floor", 107, 14));
        mainFloor.put("169", new Room("169", "This is room 169 in the main floor", 113, 14));

        //y=12
        mainFloor.put("172", new Room("172", "This is room 172 in the main floor alsos known as the band room", 130, 12));
        mainFloor.put("173", new Room("173", "This is room 173 in the main floor", 126, 12));
        mainFloor.put("174", new Room("174", "This is room 174 in the main floor alsos known as the choral room", 123, 12));
        mainFloor.put("175", new Room("175", "This is room 175 in the main floor", 123, 12));

        //x=115
        mainFloor.put("190", new Room("190", "This is room 190 in the main floor", 115, 29));
        mainFloor.put("191", new Room("191", "This is room 191 in the main floor", 115, 32));

        //y=38
        mainFloor.put("192", new Room("192", "This is room 192 in the main floor", 99, 38));
        mainFloor.put("193", new Room("193", "This is room 193 in the main floor", 97, 38));
        mainFloor.put("194", new Room("194", "This is room 194 in the main floor", 99, 38));
        mainFloor.put("195", new Room("195", "This is room 195 in the main floor", 97, 38));
        mainFloor.put("196", new Room("196", "This is room 196 in the main floor", 89, 38));
        mainFloor.put("199B", new Room("199B", "This is room 199B in the main floor also known as the Dance room", 58, 38));


        mainFloor.put("199", new Room("199", "This is room 199 in the main floor also known as the Gymnasium", 79, 44));
        mainFloor.put("Auditorium", new Room("Auditorium", "This is the auditorium in the main floor", 115, 30));

        mainFloor.put("Court Yard 1", new Room("Court Yard 1", "This is Court Yard 1 in the main floor", 90, 38));
        mainFloor.put("Court Yard 2", new Room("Court Yard 2", "This is Court Yard 2 in the main floor", 76, 38));
        mainFloor.put("Dining", new Room("Dining", "This is the cafeteria in the main floor", 130, 18));

        mainFloor.put("Main Office", new Room("Main Office", "This is the main office in the main floor", 51, 14));

        mainFloor.put("Stair 1", new Room("Stair 1", "This is the main stairway which leads up", 44, 8));
        mainFloor.put("Stair 2", new Room("Stair 2", "This stairway leads down and is behind the main stairwell", 40, 14));
        mainFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 16, 14));
        mainFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 14, 45));
        mainFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 33, 56));
        mainFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 51, 38));
        mainFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 50));
        mainFloor.put("Stair 9", new Room("Stair 9", "This stairway leads to the top floor and is next to the media center and exit", 83, 4));
        mainFloor.put("Stair 10", new Room("Stair 10", "This stairway leads down to the art wing", 115, 38));
        mainFloor.put("TV Studio", new Room("TV Studio", "This is the TV studioin the main floor", 115, 9));
    }


    static private void fillsecond() {
        secondFloor = new Hashtable<String, Room>();
        //y=14
        secondFloor.put("200", new Room("200", "This is room 200 in the second floor", 30, 14));
        secondFloor.put("203", new Room("203", "This is room 204 in the second floor", 30, 14));
        secondFloor.put("204", new Room("204", "This is room 204 in the second floor", 26, 14));
        secondFloor.put("205", new Room("205", "This is room 205 in the second floor", 24, 14));

        //x=14
        secondFloor.put("207", new Room("207", "This is room 207 in the second floor", 14, 14));
        secondFloor.put("208", new Room("208", "This is room 208 in the second floor", 14, 21));
        secondFloor.put("209", new Room("209", "This is room 209 in the second floor", 14, 31));
        secondFloor.put("210", new Room("210", "This is room 210 in the second floor", 14, 28));
        secondFloor.put("211", new Room("211", "This is room 211 in the second floor", 14, 36));

        //y=58
        secondFloor.put("213", new Room("213", "This is room 213 in the second floor", 21, 58));
        secondFloor.put("214", new Room("214", "This is room 214 in the second floor", 27, 58));

        //x=36
        secondFloor.put("215", new Room("215", "This is room 215 in the second floor", 36, 46));

        //y=38
        secondFloor.put("220", new Room("220", "This is room 220 in the second floor", 17, 38));
        secondFloor.put("221", new Room("221", "This is room 221 in the second floor", 18, 38));
        secondFloor.put("222", new Room("222", "This is room 222 in the second floor", 35, 38));
        secondFloor.put("223", new Room("223", "This is room 223 in the second floor", 29, 38));
        secondFloor.put("224", new Room("224", "This is room 224 in the second floor", 40, 38));
        secondFloor.put("225", new Room("225", "This is room 225 in the second floor", 41, 38));
        secondFloor.put("226", new Room("226", "This is room 226 in the second floor", 44, 38));
        secondFloor.put("227", new Room("227", "This is room 227 in the second floor", 49, 38));
        secondFloor.put("228", new Room("228", "This is room 228 in the second floor", 53, 38));

        //x=51
        secondFloor.put("229", new Room("229", "This is room 229 in the second floor", 51, 32));
        secondFloor.put("230", new Room("230", "This is room 230 in the second floor", 51, 32));
        secondFloor.put("231", new Room("231", "This is room 231 in the second floor", 51, 30));
        secondFloor.put("232", new Room("232", "This is room 232 in the second floor", 51, 30));
        secondFloor.put("233", new Room("233", "This is room 233 in the second floor", 51, 20));
        secondFloor.put("234", new Room("234", "This is room 234 in the second floor", 51, 20));
        secondFloor.put("235", new Room("235", "This is room 235 in the second floor", 51, 18));
        secondFloor.put("236", new Room("236", "This is room 236 in the second floor", 51, 16));
        secondFloor.put("237", new Room("237", "This is room 237 in the second floor", 51, 18));
        secondFloor.put("238", new Room("238", "This is room 238 in the second floor", 51, 9));
        secondFloor.put("239", new Room("239", "This is room 239 in the second floor", 51, 7));
        secondFloor.put("241", new Room("241", "This is room 241 in the second floor", 51, 7));
        secondFloor.put("242", new Room("242", "This is room 242 in the second floor", 51, 9));

        //y=14
        secondFloor.put("243", new Room("243", "This is room 243 in the second floor", 58, 14));
        secondFloor.put("244", new Room("244", "This is room 244 in the second floor", 50, 14));
        secondFloor.put("245", new Room("245", "This is room 245 in the second floor", 61, 14));
        secondFloor.put("246", new Room("246", "This is room 246 in the second floor", 69, 14));
        secondFloor.put("247", new Room("247", "This is room 247 in the second floor", 64, 14));
        secondFloor.put("248", new Room("248", "This is room 248 in the second floor", 74, 14));
        secondFloor.put("249", new Room("249", "This is room 249 in the second floor", 75, 14));
        secondFloor.put("250", new Room("250", "This is room 250 in the second floor", 75, 14));

        //x=83
        secondFloor.put("254", new Room("254", "This is room 254 in the second floor", 83, 16));
        secondFloor.put("255", new Room("255", "This is room 255 in the second floor", 83, 24));
        secondFloor.put("256", new Room("256", "This is room 256 in the second floor", 83, 29));
        secondFloor.put("257", new Room("257", "This is room 257 in the second floor", 83, 30));
        secondFloor.put("258", new Room("258", "This is room 258 in the second floor", 83, 32));
        secondFloor.put("259", new Room("259", "This is room 259 in the second floor", 83, 38));

        secondFloor.put("Stair 1", new Room("Stair 1", "This is the main stairway which leads up", 43, 14));
        secondFloor.put("Stair 3", new Room("Stair 3", "This down stairway connects all the floor and is in the science wing", 16, 14));
        secondFloor.put("Stair 4", new Room("Stair 4", "This is a large stairway connecting all three floors", 14, 45));
        secondFloor.put("Stair 5", new Room("Stair 5", "This is a small stairway connecting all three floors in the ESOL wing", 33, 57));
        secondFloor.put("Stair 6", new Room("Stair 6", "This down stairway connects all three floors and is in the middle of the math Wing", 51, 38));
        secondFloor.put("Stair 8", new Room("Stair 8", "This large stairway connects all three floors and leads to the art wing", 79, 50));
        secondFloor.put("Stair 9", new Room("Stair 9", "This stairway leads to the top floor and is next to the media center and exit", 83, 4));
    }
}

