package com.example.earthquacke;

public class quackeinfo  {
    private double magnitude;
    private String location;
    private String location1;

    private String date;

    private String time;

    private  String url;

    public quackeinfo(double magnitude, String location,String location1, String date,String time,String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.location1 = location1;
        this.date =date;
        this .time=time;
        this.url=url;
    }
    public double getMagnitude() {
        return magnitude;
    }
    public String getLocation() {
        return location;
    }
    public String getLocation1() {
        return location1;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getUrl() {
        return url;
    }
}
