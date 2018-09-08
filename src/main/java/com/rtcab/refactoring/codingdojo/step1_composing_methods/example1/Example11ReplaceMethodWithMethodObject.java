package com.rtcab.refactoring.codingdojo.step1_composing_methods.example1;

public class Example11ReplaceMethodWithMethodObject {


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
