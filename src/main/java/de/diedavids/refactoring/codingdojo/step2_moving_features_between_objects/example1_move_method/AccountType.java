package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method;

public class AccountType {

    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

}
