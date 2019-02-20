package com.exabarermple.latif.bookingapplication;

import com.google.gson.annotations.SerializedName;

public class Post {


    private String name;
    private String surname;
    private String date;
    private String telephoneNumber;
    private String time;
    private String rezervationDate;
    private boolean isActive;

    public Post(String name, String surname, String date, String telephoneNumber, String time) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.telephoneNumber = telephoneNumber;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getTime() {
        return time;
    }

    public String getRezervationDate() {
        return rezervationDate;
    }

    public boolean isActive() {
        return isActive;
    }
}
