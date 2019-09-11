package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.exception.CustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public void validateMobileNumber(String mobileNumber) throws CustomException{
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(mobileNumber);
        if(!(m.find() && m.group().equals(mobileNumber)))
            throw new CustomException("Invalid mobile number");
    }

    public void validateEmail(String email) throws CustomException{
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || !pat.matcher(email).matches())
            throw new CustomException("Email address is null");
    }

}
