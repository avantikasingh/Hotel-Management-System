package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dto.Booking;

import java.util.Comparator;

public class CompareByDate implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if(o1.getCheckIn().isBefore(o2.getCheckIn())){
            return -1;
        }
        return 1;
    }
}
