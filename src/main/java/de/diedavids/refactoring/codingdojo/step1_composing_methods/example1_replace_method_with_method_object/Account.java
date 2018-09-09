package de.diedavids.refactoring.codingdojo.step1_composing_methods.example1_replace_method_with_method_object;

public class Account {


    public int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;

        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }

        int importantValue3 = importantValue2 * 7;

        // and so on

        return importantValue3 - 2 * importantValue1;
    }

    public int delta() {
        return 42;
    }


}
