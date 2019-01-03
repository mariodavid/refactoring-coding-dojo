package de.diedavids.refactoring.codingdojo.step1_composing_methods.example1_replace_method_with_method_object;

public class Account {


    public int gamma(int inputVal, int quantity, int yearToDate) {
        return new AccountGamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 42;
    }


}
