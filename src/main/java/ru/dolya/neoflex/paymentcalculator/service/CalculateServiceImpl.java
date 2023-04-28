package ru.dolya.neoflex.paymentcalculator.service;

import org.springframework.stereotype.Service;
import ru.dolya.neoflex.paymentcalculator.model.Payment;
import ru.dolya.neoflex.paymentcalculator.model.ProductionCalendar;
import ru.dolya.neoflex.paymentcalculator.parser.ProductionCalendarParser;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService {

    private final ProductionCalendarParser productionCalendarParser;

    public CalculateServiceImpl() {
        this.productionCalendarParser = new ProductionCalendarParser();
    }

    public Payment calculate(BigDecimal avgSalary, int vacationDays, LocalDate date) {

            ProductionCalendar productionCalendar = productionCalendarParser.getProductionCalendar();
            BigDecimal yearSalary = avgSalary.multiply(BigDecimal.valueOf(12));
            BigDecimal salaryPerDay = yearSalary.divide(BigDecimal.valueOf(productionCalendar.getWorkDays()) , 2, RoundingMode.HALF_UP);
            BigDecimal vacationPayment;
            if (date == null) {
                vacationPayment = salaryPerDay.multiply(BigDecimal.valueOf(vacationDays));
            } else {
                List<LocalDate> holidays = productionCalendar.getHolidays();
                int newVacationDays = vacationDays;
                for (int i = 0; i < vacationDays; i++) {
                    if (holidays.contains(date.plusDays(i))) {
                        newVacationDays--;
                    }
                }
                vacationPayment = salaryPerDay.multiply(BigDecimal.valueOf(newVacationDays));
            }
            return new Payment(vacationPayment.setScale(2, RoundingMode.HALF_UP));
    }
}
