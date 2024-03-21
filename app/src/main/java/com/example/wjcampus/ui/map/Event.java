package com.example.wjcampus.ui.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import java.util.TimeZone;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String date;
    private String summary;

    public Event(String date, String summary) {
        this.date = date;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public Date getDay() {
        try {
            String pattern = "yyyyMMdd";
            if(date.length() > 15) {
                pattern = "yyyyMMdd'T'HHmmss'Z'";
            } else if(date.length() > 8) {
                pattern = "yyyyMMdd'T'HHmmss";
            }
            SimpleDateFormat inputDateFormat = new SimpleDateFormat(pattern);
            Date day = inputDateFormat.parse(date);

            return day;
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        return null;
    }

    public String getDayString() {

        String inPattern = "yyyyMMdd";
        String outPattern = "MM/dd/yyyy";
        if(date.length() > 15) {
            inPattern = "yyyyMMdd'T'HHmmss'Z'";
            outPattern = "MM/dd/yyyy HH:mm";
        } else if(date.length() > 8) {
            inPattern = "yyyyMMdd'T'HHmmss";
            outPattern = "MM/dd/yyyy HH:mm";
        }

        try {
            // Create a SimpleDateFormat object to parse the input date and time
            SimpleDateFormat inputFormat = new SimpleDateFormat(inPattern);
            inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            // Parse the input string to obtain a Date object
            Date date1 = inputFormat.parse(date);

            // Create a SimpleDateFormat object to format the output date and time
            SimpleDateFormat outputFormat = new SimpleDateFormat(outPattern);
            outputFormat.setTimeZone(TimeZone.getDefault()); // Adjust the time zone as needed

            // Format the Date object to obtain the formatted date and time string
            return outputFormat.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSummary() {
        return summary;
    }

    public String getDate() {
        return date;
    }
}

