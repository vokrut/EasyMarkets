package com.kengoweb.easymarkets.appartments;

import com.kengoweb.easymarkets.bookings.Booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Appartment implements Serializable {

    private int id;
    private String name;
    private int bedrooms;
    private List<Booking> bookingList;

    public Appartment(int id, String name, int bedrooms) {
        this.id = id;
        this.name = name;
        this.bedrooms = bedrooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public static List<Appartment> getInitialListAppartments() {
        List<Appartment> appartmentList = new ArrayList<>();
        int id = 0;
        for (int i = 1; i <= 4; i++) {
            appartmentList.add(new Appartment(++id, "Appartment " + i + " one-bedroom", 1));
        }

        for (int i = 1; i <= 3; i++) {
            appartmentList.add(new Appartment(++id,"Appartment " + i + " two-bedroom", 2));
        }

        for (int i = 1; i <= 3; i++) {
            appartmentList.add(new Appartment(++id, "Appartment " + i + " three-bedroom", 3));
        }
        return appartmentList;
    }

    @Override
    public String toString() {
        return "Appartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bedrooms=" + bedrooms +
                '}';
    }
}
