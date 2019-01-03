package de.diedavids.refactoring.codingdojo.step4_generalization.example1_extract_interface;

public class Timesheet {


    public double charge(Employee employee, int days) {
        int base = employee.getRate() * days;
        if (employee.hasSpecialSkill()) {
            return base * 1.05d;
        }

        return base;
    }
}
