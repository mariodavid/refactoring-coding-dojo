package de.diedavids.refactoring.codingdojo.step4_generalization.example1_extract_interface;

public class Employee implements Billable {


    private int rate;
    private boolean specialSkill;

    public int getRate() {
        return rate;
    }

    public boolean hasSpecialSkill() {
        return specialSkill;
    }


    public void getDrunk() {
        // ...
    }

}
