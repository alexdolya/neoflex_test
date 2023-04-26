package ru.dolya.neoflex.vacationpaycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dolya.neoflex.vacationpaycalculator.model.VacationPay;
import ru.dolya.neoflex.vacationpaycalculator.service.CalculateService;



@RestController
public class CalculateController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping("/calculate")
    public VacationPay getHolidayPay(@RequestParam double avgSalary, @RequestParam int vacationDays){
        return calculateService.calculate(avgSalary, vacationDays);
    }

}
