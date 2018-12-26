package de.diedavids.refactoring.codingdojo.introduction_example

import spock.lang.Specification

class CustomerStatementRenterPointsSpec extends Specification {

  private static final Movie THE_HULK = new Movie("The Hulk", Movie.CHILDREN);
  private static final Movie IRON_MAN = new Movie("Iron Man 4", Movie.NEW_RELEASE);
  private static final Movie SPIDER_MAN = new Movie("Spiderman", Movie.REGULAR)
  private Customer customer

  void setup() {
    customer = new Customer("Manfred")
  }

  def "renter points is 1 for a 'regular' movie rented for 2 days"() {
    given:
    rent(SPIDER_MAN, 2)
    expect:
    renterPointsIs(1)
  }

  def "renter points is 2 for a 'new release' movie rented for 2 days"() {
    given:
    rent(IRON_MAN, 2)
    expect:
    renterPointsIs(2)
  }


  def "renter points sums the renter points of all rentals"() {
    given:
    rent(SPIDER_MAN, 1)
    rent(THE_HULK, 1)
    rent(IRON_MAN, 1)

    expect:
    renterPointsIs(3)
  }


  protected rent(Movie movie, int daysRented) {
    customer.addRental(new Rental(movie, daysRented))
  }

  protected void renterPointsIs(int expectedRenterPoints) {
    assert customer.statement().contains("You earned $expectedRenterPoints frequent renter points")
  }
}
