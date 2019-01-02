package de.diedavids.refactoring.codingdojo.introduction_example;

public abstract class Price {

  abstract int getPriceCode();

  abstract double getCharge(int daysRented);

  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
