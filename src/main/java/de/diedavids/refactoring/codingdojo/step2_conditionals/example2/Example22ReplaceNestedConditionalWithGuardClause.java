package de.diedavids.refactoring.codingdojo.step2_conditionals.example2;

public class Example22ReplaceNestedConditionalWithGuardClause {

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
        double result;
        if (isDead()) {
            result = deadAmount();
        }
        else {
            if (isSeparated()) {
                result = separatedAmount();
            }
            else {
                if (isRetired()) {
                    result = retiredAmount();
                }
                else {
                    result = normalPayAmount();
                }
            }
        }

        return result;
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
