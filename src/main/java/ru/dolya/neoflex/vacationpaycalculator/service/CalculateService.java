package ru.dolya.neoflex.vacationpaycalculator.service;

import ru.dolya.neoflex.vacationpaycalculator.model.VacationPay;

public interface CalculateService {
    VacationPay calculate(double avgSalary, int vacationDays);
}
