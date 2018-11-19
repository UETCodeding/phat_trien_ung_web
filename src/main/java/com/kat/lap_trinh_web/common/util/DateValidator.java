package com.kat.lap_trinh_web.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    public boolean isThisDateValid(String dateToValidate, String dateFormat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }



}
