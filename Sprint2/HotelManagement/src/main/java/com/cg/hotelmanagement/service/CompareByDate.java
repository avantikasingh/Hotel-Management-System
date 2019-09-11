package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dto.Booking;

import java.util.Comparator;
import java.util.Date;

public class CompareByDate implements Comparator<Date> {
    @Override
    public int compare(Date o1, Date o2) {
        if(o1.before(o2)){
            return -1;
        }
        return 1;
    }
}
