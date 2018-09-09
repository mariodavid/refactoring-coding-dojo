package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method;

public class Account {


    int daysOverdrawn;

    AccountType type;


    double overdraftCharge() {
        double result;
        if (type.isPremium()) {
            result = 10d;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        }
        return daysOverdrawn * 1.75d;
    }


}
