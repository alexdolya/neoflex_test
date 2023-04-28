package ru.dolya.neoflex.paymentcalculator;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.dolya.neoflex.paymentcalculator.model.Payment;
import ru.dolya.neoflex.paymentcalculator.service.CalculateServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceImplTest {
    private static BigDecimal avgSalary;
    private static int vacationDays;
    private static LocalDate date;
    private static LocalDate dateWithOneHoliday;
    private static CalculateServiceImpl calculateService;

    @BeforeAll
    public static void init() {
        avgSalary = new BigDecimal("50000.00");

        vacationDays = 10;
        date = LocalDate.of(2023, 7, 1);
        dateWithOneHoliday = LocalDate.of(2023, 2, 22);
        calculateService = new CalculateServiceImpl();
    }

    @Test
    void calculateTestWithNullDate() {
        Payment expectedPayment = new Payment(new BigDecimal("24291.50"));
        Payment actualPayment = calculateService.calculate(avgSalary, vacationDays, null);
        assertEquals(expectedPayment.getVacationPay(), actualPayment.getVacationPay());
    }

    @Test
    void calculateTestWithDateButNoHolidays() {
        Payment expectedPayment = new Payment(new BigDecimal("24291.50"));
        Payment actualPayment = calculateService.calculate(avgSalary, vacationDays, date);
        assertEquals(expectedPayment.getVacationPay(), actualPayment.getVacationPay());
    }

    @Test
    void calculateTestWithOneHoliday() {
        Payment expectedPayment = new Payment(new BigDecimal("21862.35"));
        Payment actualPayment = calculateService.calculate(avgSalary, vacationDays, dateWithOneHoliday);
        assertEquals(expectedPayment.getVacationPay(), actualPayment.getVacationPay());

    }

}
