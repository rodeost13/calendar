package com.example.newcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DayInfo
{
    private String day;
    private boolean inMonth;
    private Date date;
    public String getDay()
    {
        return day;
    }
    public void setDay(String day)
    {
        this.day = day;
    }
    public boolean isInMonth()
    {
        return inMonth;
    }
    public void setInMonth(boolean inMonth)
    {
        this.inMonth = inMonth;
    }

}



