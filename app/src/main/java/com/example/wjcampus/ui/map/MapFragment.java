package com.example.wjcampus.ui.map;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wjcampus.R;
import com.example.wjcampus.databinding.FragmentMapBinding;
import com.ortiz.touchview.TouchImageView;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapFragment extends Fragment {

    public SchoolMap schoolMap;
    public Hashtable<String, Room>[] allFloors;
    public Room startRoom;
    public Room destRoom;
    public int startFloor;
    public int destFloor;
    public TouchImageView mapView;
    public Bitmap[] bitMaps;
    public int currFloor = 1;

    public int[] pngMaps;
    public TouchImageView pathView;
    public Bitmap[][] allFrames;
    private AnimationDrawableBitmaps animationDrawable;
    private FragmentMapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        schoolMap = new SchoolMap();

        allFloors = new Hashtable[3];
        allFloors[0] = Floors.getFloor(0);
        allFloors[1] = Floors.getFloor(1);
        allFloors[2] = Floors.getFloor(2);

        //Adding the onClick listeners for the buttons

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);

    }

    /*
     * The method onViewCreated is needed needed to add onclick events for views in fragments
     */
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        schoolMap = new SchoolMap();

        ScheduleHelper downloadTask = new ScheduleHelper();

        allFloors = new Hashtable[3];
        allFloors[0] = Floors.getFloor(0);
        allFloors[1] = Floors.getFloor(1);
        allFloors[2] = Floors.getFloor(2);


        mapView = view.findViewById(R.id.mapView);


        String[][][] map = SchoolMap.map;
        bitMaps = new Bitmap[3];


        //String[][][] expandedMap = expandArray(map);
        flattenMap(map);

        pngMaps = new int[3];
        pngMaps[0] = R.drawable.bottomfloor;
        pngMaps[1] = R.drawable.mainfloor;
        pngMaps[2] = R.drawable.upperfloor;

        pathView = view.findViewById(R.id.pathView);
        pathView.setImageResource(pngMaps[1]);

        int startId = getResources().getIdentifier("startBTN", "id", getContext().getPackageName());
        Button startBtn = view.findViewById(startId);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectStartRoom(getView());
            }
        });

        int destId = getResources().getIdentifier("destBTN", "id", getContext().getPackageName());
        Button destBtn = view.findViewById(destId);
        destBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDestRoom(getView());
            }
        });

        int groundFloorBTNID = getResources().getIdentifier("groundFloorBtn", "id", getContext().getPackageName());
        Button groundFloorBTN = view.findViewById(groundFloorBTNID);
        groundFloorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(getView(),0);
            }
        });

        int firstFloorBTNID = getResources().getIdentifier("firstFloorBtn", "id", getContext().getPackageName());
        Button firstFloorBTN = view.findViewById(firstFloorBTNID);
        firstFloorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(getView(),1);
            }
        });

        int secondFloorBTNID = getResources().getIdentifier("secondFloorBtn", "id", getContext().getPackageName());
        Button secondFloorBTN = view.findViewById(secondFloorBTNID);
        secondFloorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(getView(),2);
            }
        });

//        int upId = getResources().getIdentifier("floorUp", "id", getContext().getPackageName());
//        Button upBtn = view.findViewById(upId);
//        upBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                floorUp(getView());
//            }
//        });
//
//        int downId = getResources().getIdentifier("floorDown", "id", getContext().getPackageName());
//        Button downBtn = view.findViewById(downId);
//        downBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                floorDown(getView());
//            }
//        });

        int printId = getResources().getIdentifier("printBTN", "id", getContext().getPackageName());
        Button printBtn = view.findViewById(printId);
        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printRoute(getView());
            }
        });
    }


    public void flattenMap(String[][][] map) {
        for (int floor = 0; floor < 3; floor++) {
            int[] pixelFloor = new int[9600];


            for(int row = 0; row < 64; row++) {
                for(int cell = 0; cell < 150; cell++) {
                    String cellVal = map[floor][row][cell];
                    if(cellVal.equals(".")) {
                        pixelFloor[cell + row * 64] = 0x00FFFFFF;
                    } else if(cellVal.equals("*")) {
                        pixelFloor[cell + row * 64] = 0xC0C0C0FF;
                    } else if(cellVal.equals("#") || cellVal.equals("X")) {
                        pixelFloor[cell + row * 64] = 0xFF000000;
                    } else if(cellVal.equals("/")) {
                        pixelFloor[cell + row * 64] = 0xFF0000FF;
                    } else if(cellVal.equals("@")) {
                        pixelFloor[cell + row * 64] = 0xFFFF0000;
                    }else {
                        pixelFloor[cell + row * 64] = 0xFF00FFFF;
                    }
                }
            }
            Bitmap bitFloor = Bitmap.createBitmap(pixelFloor, 150, 64, Bitmap.Config.ARGB_8888);
            bitMaps[floor] = bitFloor;
        }
        mapView.setImageBitmap(bitMaps[1]);
    }


    public Bitmap flattenMap(String[][] map, int scale) {
        int[] pixelFloor = new int[9600];
        for(int row = 0; row < 64; row++) {
            for(int cell = 0; cell < 150; cell++) {
                String cellVal = map[row][cell];
                if(cellVal.equals(".") || cellVal.equals("*") || cellVal.equals("#") || cellVal.equals("X") || cellVal.equals("/")) {
                    pixelFloor[cell + row * 150] = 0x00FFFFFF;
                } else if(cellVal.equals("@")) {
                    pixelFloor[cell + row * 150] = 0xFFFF0000;
                }else {
                    pixelFloor[cell + row * 150] = 0xFF00FFFF;
                }
            }
        }
        Bitmap bitFloor = Bitmap.createBitmap(pixelFloor, 150, 64, Bitmap.Config.ARGB_8888);
        if(scale > 1) {
            bitFloor = Bitmap.createScaledBitmap(bitFloor, 150*scale, 64*scale, false);
        }
        return bitFloor;
    }

    //For the ground floor button
    public void goToFloor(View view, int floor) {
        mapView.setImageBitmap(bitMaps[floor]);
        pathView.setImageResource(pngMaps[floor]);
        if (animationDrawable != null) {
            animationDrawable.setCurrentFloor(currFloor);
        }
    }

    //The functions are for the original floor change buttons (we'll be using the new ones above)
    public void floorUp(View view) {
        if(currFloor < 2) {
            mapView.setImageBitmap(bitMaps[currFloor+1]);
            pathView.setImageResource(pngMaps[currFloor+1]);
            currFloor += 1;
            if(animationDrawable != null) {
                animationDrawable.setCurrentFloor(currFloor);
            }
        }
    }


    public void floorDown(View view) {
        if(currFloor > 0) {
            mapView.setImageBitmap(bitMaps[currFloor-1]);
            pathView.setImageResource(pngMaps[currFloor-1]);
            currFloor -= 1;
            if(animationDrawable != null) {
                animationDrawable.setCurrentFloor(currFloor);
            }
        }
    }


    public void selectStartRoom(View view) {
        EditText startSearchBar = view.findViewById(R.id.startSearchBar);
        String startText = startSearchBar.getText().toString();
        TextView startTextView = view.findViewById(R.id.startRoom);


        int floorNumber = 0;


        for (Hashtable<String, Room> floor: allFloors) {
            if(floor.containsKey(startText)){
                break;
            }
            floorNumber++;
        }
        if(floorNumber == 3) {
            startTextView.setText("DNE");
            return;
        }
        startRoom = allFloors[floorNumber].get(startText);
        startFloor = floorNumber;
        startTextView.setText(startText);
    }


    public void selectDestRoom(View view) {
        EditText destSearchBar = view.findViewById(R.id.destSearchBar);
        String destText = destSearchBar.getText().toString();
        TextView destTextView = view.findViewById(R.id.destRoom);
        destTextView.setText(destText);


        int floorNumber = 0;


        for (Hashtable<String, Room> floor: allFloors) {
            if(floor.containsKey(destText)){
                break;
            }
            floorNumber++;
        }
        if(floorNumber == 3) {
            destTextView.setText("DNE");
            return;
        }
        destRoom = allFloors[floorNumber].get(destText);
        destFloor = floorNumber;
        destTextView.setText(destText);
    }


    public Bitmap[] createFloorAnimation(String[][] floor, PathResults paths) {
        Bitmap[] animations = new Bitmap[paths.directions.size()];
        int currX = paths.startX;
        int currY = paths.startY;
        String[][][] allTempFrames = new String[paths.directions.size()][floor.length][];
        for(int step = 0; step < paths.directions.size(); step++) {
            String[][] tempFrame = new String[floor.length][];
            for(int row = 0; row < floor.length; row++) {
                String[] tempRow = floor[row].clone();
                tempFrame[row] = tempRow;
            }
            switch (paths.directions.get(step)) {
                case Top:
                    currY -= 1;
                    break;
                case Left:
                    currX -= 1;
                    break;
                case Right:
                    currX += 1;
                    break;
                case Bottom:
                    currY += 1;
                    break;
                default:
                    System.out.println(paths.directions.get(step));
            }
            tempFrame[currY][currX] = "@";
            allTempFrames[step] = tempFrame;
        }
        int threadNum = 8;
        FlattenThread[] allThreads = new FlattenThread[threadNum];
        int frameCount = allTempFrames.length;
        int incFrames = frameCount/threadNum;
        int currFrame = 0;
        for(int frame = 0; frame < threadNum; frame++) {
            if(frame + 1 == threadNum) {
                allThreads[frame] = new FlattenThread(currFrame, frameCount, animations, allTempFrames);
            } else {
                allThreads[frame] = new FlattenThread(currFrame, currFrame+incFrames, animations, allTempFrames);
            }
            allThreads[frame].start();
            currFrame += incFrames;
        }
        for(int frame = 0; frame < threadNum; frame++) {
            try {
                allThreads[frame].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return animations;
    }

    public static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
    public class FlattenThread extends Thread {
        int minIndex;
        int maxIndex;
        String[][][] frames;
        Bitmap[] animations;
        public FlattenThread(int minIndex, int maxIndex, Bitmap[] animations, String[][][] frames) {
            this.frames = frames;
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
            this.animations = animations;
        }
        public void run() {
            for(int min = minIndex; min < maxIndex; min++) {
                updateFrames(min, flattenMap(frames[min], 4));
            }
        }
        synchronized private void updateFrames(int ind, Bitmap frame){


            animations[ind] = frame;
        }
    }

    public void printRoute(View view) {
        if (startRoom == null || destRoom == null) {
            return;
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            long startTime2 = System.nanoTime();
            List<PathResults> results = Path.findShortestPath(startRoom, startFloor, destRoom, destFloor);
            schoolMap.markPaths(results);
            long endTime2 = System.nanoTime();
            double elapsedTimeInSeconds2 = (endTime2 - startTime2) / 1_000_000_000;
            System.out.println(elapsedTimeInSeconds2);


            String[][][] tempMap = SchoolMap.tempMap;


            allFrames = new Bitmap[3][results.size()];


            long startTime = System.nanoTime();
            for (int floor = 0; floor < results.size(); floor++) {
                switch (results.get(floor).floor) {
                    case 0:
                        allFrames[0] = createFloorAnimation(tempMap[0], results.get(floor));
                        break;
                    case 1:
                        allFrames[1] = createFloorAnimation(tempMap[1], results.get(floor));
                        break;
                    case 2:
                        allFrames[2] = createFloorAnimation(tempMap[2], results.get(floor));
                }
            }
            for (int floor = 0; floor < 3; floor++) {
                if (allFrames[floor][0] == null) {
                    Bitmap[] tempFrameMap = new Bitmap[]{bitMaps[floor]};
                    allFrames[floor] = tempFrameMap;
                }
            }


            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000;
            System.out.println(elapsedTimeInSeconds);


            int frameDuration = 200;


            if (animationDrawable != null) {
                animationDrawable.stop();
            }


            getActivity().runOnUiThread(() -> {
                animationDrawable = new AnimationDrawableBitmaps(allFrames, frameDuration, currFloor);


                animationDrawable.setImageView(mapView);


                animationDrawable.setOnAnimationEndListener(new Runnable() {
                    @Override
                    public void run() {
                        animationDrawable.updateDrawable();
                    }
                });
                animationDrawable.start();
            });


        });
    }


}