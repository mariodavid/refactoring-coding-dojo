package de.diedavids.refactoring.codingdojo.step4_generalization.example1_extract_interface;

public class Timesheet {


    public double charge(Billable billable, int days) {
        int base = billable.getRate() * days;
        if (billable.hasSpecialSkill()) {
            return base * 1.05d;
        }
        return base;
    }
}
