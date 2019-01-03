package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method;

public class Account {


    int daysOverdrawn;

    AccountType type;


    double overdraftCharge() {
        int daysOverdrawn = this.daysOverdrawn;
        return type.overdraftCharge(daysOverdrawn);
    }


}
