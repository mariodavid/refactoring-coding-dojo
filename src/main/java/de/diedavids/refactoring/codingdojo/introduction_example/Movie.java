package de.diedavids.refactoring.codingdojo.introduction_example;

public class Movie {

  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String title;

  Price price;

  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public String getTitle() {
    return title;
  }

  public void setPriceCode(int priceCode) {
    switch (priceCode) {
      case REGULAR:
        price = new RegularPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      case CHILDREN:
        price = new ChildrenPrice();
        break;
    }
  }

  int getFrequentRenterPoints(int daysRented) {
    return price.getFrequentRenterPoints(daysRented);
  }

  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }
}
