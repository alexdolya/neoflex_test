package ru.dolya.neoflex.test.service;

import ru.dolya.neoflex.test.model.VacationPay;

public interface CalculateService {
    VacationPay calculate(double avgSalary, int vacationDays);
}
