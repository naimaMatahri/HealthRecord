package com.example.personalhealthrecord;

public class AddAppointment {

    private String location, reason, time, date;

    public AddAppointment(String date, String time, String location, String reason) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getReason() {
        return reason;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
