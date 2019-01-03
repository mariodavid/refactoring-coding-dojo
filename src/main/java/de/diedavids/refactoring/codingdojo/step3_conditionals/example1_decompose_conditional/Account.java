package de.diedavids.refactoring.codingdojo.step3_conditionals.example1_decompose_conditional;

import java.time.LocalDate;

public class Account {


    private static final LocalDate SUMMER_START = LocalDate.of(2018,6,21);
    private static final LocalDate SUMMER_END = LocalDate.of(2018,9,23);

    private double winterRate;
    private double winterServiceCharge;
    private double summerRate;

    public double getWinterRate() {
        return winterRate;
    }

    public void setWinterRate(double winterRate) {
        this.winterRate = winterRate;
    }

    public double getWinterServiceCharge() {
        return winterServiceCharge;
    }

    public void setWinterServiceCharge(double winterServiceCharge) {
        this.winterServiceCharge = winterServiceCharge;
    }

    public double getSummerRate() {
        return summerRate;
    }

    public void setSummerRate(double summerRate) {
        this.summerRate = summerRate;
    }


    public double getCharge(LocalDate dateToCharge, int quantity) {

        double charge;

        if (notSummer(dateToCharge)) {
            charge = winterCharge(quantity);
        }
        else {
            charge = summerCharge(quantity);
        }

        return charge;
    }

    private double summerCharge(int quantity) {
        return quantity * summerRate;
    }

    private double winterCharge(int quantity) {
        return quantity * winterRate + winterServiceCharge;
    }

    private boolean notSummer(LocalDate dateToCharge) {
        return dateToCharge.isBefore(SUMMER_START) || dateToCharge.isAfter(SUMMER_END);
    }
}
