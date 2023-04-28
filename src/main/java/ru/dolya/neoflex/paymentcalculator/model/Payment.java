package ru.dolya.neoflex.paymentcalculator.model;

import java.math.BigDecimal;

public class Payment {

    private final BigDecimal vacationPay;

    public Payment(BigDecimal vacationPay) {
        this.vacationPay = vacationPay;
    }

    public BigDecimal getVacationPay() {
        return vacationPay;
    }

}
