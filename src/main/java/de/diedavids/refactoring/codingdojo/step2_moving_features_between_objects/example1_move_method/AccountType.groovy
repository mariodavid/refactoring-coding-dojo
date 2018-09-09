package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method

class AccountType {

    boolean premium;

    boolean isPremium() {
        return premium
    }

    void setPremium(boolean premium) {
        this.premium = premium
    }
}
