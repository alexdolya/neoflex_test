package ru.dolya.neoflex.paymentcalculator.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dolya.neoflex.paymentcalculator.model.Payment;
import ru.dolya.neoflex.paymentcalculator.service.CalculateService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Validated
@RestController
public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping("/calculate")
    public Payment getVacationPay(
            @RequestParam("salary") @Positive @NotNull BigDecimal avgSalary,
            @RequestParam("days") @Positive @NotNull int vacationDays,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        return calculateService.calculate(avgSalary, vacationDays, date);
    }
}
