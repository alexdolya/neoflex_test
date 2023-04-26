package ru.dolya.neoflex.vacationpaycalculator.service;

import org.springframework.stereotype.Service;
import ru.dolya.neoflex.vacationpaycalculator.model.VacationPay;



@Service
public class CalculateServiceImpl implements CalculateService {

    public VacationPay calculate(double avgSalary, int vacationDays) {

        return new VacationPay(avgSalary/365*vacationDays);
    }


}
