package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method;

public class AccountType {

    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double overdraftCharge(int daysOverdrawn) {
        double result;
        if (isPremium()) {
            result = 10d;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        }
        return daysOverdrawn * 1.75d;
    }

}
