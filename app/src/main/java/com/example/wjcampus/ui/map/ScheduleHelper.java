package com.example.wjcampus.ui.map;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.text.SimpleDateFormat;

public class ScheduleHelper extends AsyncTask<String, Void, String> {

    static Event[] data;

    protected String doInBackground(String... urls) {
        String result = null;
        try {
            // Create a URL object from the provided URL string
            URL url = new URL(urls[0]);

            // Open an HTTP connection to the URL
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            urlConnection.setRequestMethod("GET");

            // Connect to the server
            urlConnection.connect();

            // Check if the response code indicates success
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Get the input stream containing the response data
                InputStream inputStream = urlConnection.getInputStream();

                // Read the input stream and convert it to a string
                result = convertInputStreamToString(inputStream);

                data =breakIntoEvents(result);

                // Close the input stream
                inputStream.close();
            }

            // Disconnect the HttpURLConnection
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void onPostExecute(String icsContent) {
        // Process the retrieved .ics file content here
        // This method runs on the main UI thread and receives the result from doInBackground()
        if (icsContent != null) {
            // Print or process the .ics file content
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.contains("DTSTART") || line.contains("SUMMARY")) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private Event[] breakIntoEvents(String file) {
        Scanner scanner = new Scanner(file);

        ArrayList<Event> eventStrings = new ArrayList<Event>();

        String[] targets = {"DTSTART", "SUMMARY:"};
        int targetInd = 0;
        String[] values = new String[2];

        scanner.nextLine();
        scanner.nextLine();

        while(scanner.hasNext()) {
            String start = scanner.findWithinHorizon(targets[targetInd], 0);

            if (start == null) {
                scanner.nextLine();
                continue;
            }
            values[targetInd] = targetInd == 0 ? scanner.nextLine().substring(1) : scanner.nextLine();
            if(targetInd + 1 == targets.length)  {
                Boolean isUTC = values[0].contains("VALUE=DATE:");
                if(isUTC) {
                    values[0] = values[0].substring(11);
                }
                Boolean isTZID = values[0].contains("TZID=America/New_York:");
                if(isTZID) {
                    values[0] = values[0].substring(22);
                }
                if(Integer.parseInt(values[0].substring(0,4)) >= 2022) {
                    Event newEvent = new Event(values[0], values[1]);
                    eventStrings.add(newEvent);
                }
                targetInd = 0;
            } else {
                targetInd++;
            }
        }


        Comparator<Event> dateComparator = new Comparator<Event>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public int compare(Event e1, Event e2) {
                boolean isUTC1 = e1.getDate().length() > 8;
                boolean isUTC2 = e2.getDate().length() > 8;

                String date1 = e1.getDate();
                String date2 = e2.getDate();

                int year1 = Integer.parseInt(date1.substring(0,4));
                int year2 = Integer.parseInt(date2.substring(0,4));
                if(year2 > year1) {
                    return -1;
                } else if(year2 < year1) {
                    return 1;
                } else {
                    int month1 = Integer.parseInt(date1.substring(4,6));
                    int month2 = Integer.parseInt(date2.substring(4,6));
                    if(month2 > month1) {
                        return -1;
                    } else if(month2 < month1) {
                        return 1;
                    } else {
                        int day1 = Integer.parseInt(date1.substring(6,8));
                        int day2 = Integer.parseInt(date2.substring(6,8));
                        if(day2 > day1) {
                            return -1;
                        } else if(day2 < day1) {
                            return 1;
                        } else {
                            if(isUTC1 && !isUTC2) {
                                return 1;
                            } else if (!isUTC1 && isUTC2) {
                                return -1;
                            } else if(!isUTC1 && !isUTC2) {
                                return 0;
                            } else {
                                int hour1 = Integer.parseInt(date1.substring(9,11));
                                int hour2 = Integer.parseInt(date2.substring(9,11));
                                if(hour2 > hour1) {
                                    return -1;
                                } else if(hour2 < hour1) {
                                    return 1;
                                } else {
                                    int min1 = Integer.parseInt(date1.substring(11,13));
                                    int min2 = Integer.parseInt(date2.substring(11,13));
                                    if(min2 > min1) {
                                        return -1;
                                    } else if(min2 < min1) {
                                        return 1;
                                    } else {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };

        Event[] events = eventStrings.toArray(new Event[0]);
        Arrays.sort(events, dateComparator);

        return events;
    }
}
