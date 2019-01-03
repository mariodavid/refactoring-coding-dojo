package de.diedavids.refactoring.codingdojo.step1_composing_methods.example1_replace_method_with_method_object;

public class AccountGamma {


  private final Account source;
  private final int inputVal;
  private final int quantity;
  private final int yearToDate;

  public AccountGamma(Account source, int inputVal, int quantity, int yearToDate) {
    this.source = source;
    this.inputVal = inputVal;
    this.quantity = quantity;
    this.yearToDate = yearToDate;
  }

  public int compute() {
    int importantValue2 = getImportantValue2();

    if ((yearToDate - getImportantValue1()) > 100) {
      importantValue2 -= 20;
    }
    return calculateResult(importantValue2);
  }

  private int calculateResult(int importantValue2) {
    int importantValue3 = importantValue2 * 7;
    return importantValue3 - 2 * getImportantValue1();
  }

  private int getImportantValue2() {
    return (inputVal * yearToDate) + 100;
  }

  private int getImportantValue1() {
    return (inputVal * quantity) + source.delta();
  }
}
