package de.diedavids.refactoring.codingdojo.step3_conditionals.example2_replace_nested_condition_with_guard_clauses;

public class Employee {

    boolean dead = false;
    boolean separated = false;
    boolean retired = false;


    public boolean isSeparated() {
        return separated;
    }

    public void setSeparated(boolean separated) {
        this.separated = separated;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }


    public double getPayAmount() {
        if (isDead()) return deadAmount();
        if (isSeparated()) return separatedAmount();
        if (isRetired()) return retiredAmount();
        return normalPayAmount();
    }

    private double normalPayAmount() {
        return 40;
    }

    private double retiredAmount() {
        return 80;
    }

    private double separatedAmount() {
        return 150;
    }

    private double deadAmount() {
        return 200;
    }
}
