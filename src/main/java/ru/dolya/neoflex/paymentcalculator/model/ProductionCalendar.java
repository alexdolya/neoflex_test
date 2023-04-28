package ru.dolya.neoflex.paymentcalculator.model;

import java.time.LocalDate;
import java.util.List;


public class ProductionCalendar {

    private List<LocalDate> weekends;
    private List<LocalDate> holidays;

    public int getWorkDays() {
        return LocalDate.now().lengthOfYear() - weekends.size() - holidays.size();
    }

    public List<LocalDate> getWeekends() {
        return weekends;
    }

    public List<LocalDate> getHolidays() {
        return holidays;
    }
}
