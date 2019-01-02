package de.diedavids.refactoring.codingdojo.introduction_example;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  double getCharge() {
    return movie.getCharge(getDaysRented());
  }

  int getFrequentRenterPoints() {
    return movie.getFrequentRenterPoints(getDaysRented());
  }

}
