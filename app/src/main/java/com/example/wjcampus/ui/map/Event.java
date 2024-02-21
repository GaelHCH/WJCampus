package com.example.wjcampus.ui.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private String date;
    private String summary;

    public Event(String newDate, String newSummary) {
        date = newDate;
        summary = newSummary;
    }

    public Date getDay() {
        try {
            String pattern = "yyyyMMdd";
            if(date.length() > 8) {
                pattern = "yyyyMMdd'T'HHmmss'Z'";
            }
            SimpleDateFormat inputDateFormat = new SimpleDateFormat(pattern);
            Date day = inputDateFormat.parse(date);

            return day;
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        return null;
    }

    public String getSummary() {
        return summary;
    }

    public String getDate() {

        return date;
    }
}