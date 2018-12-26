package de.diedavids.refactoring.codingdojo.introduction_example

import spock.lang.Specification

class CustomerStatementSpec extends Specification {

  private static final Movie THE_HULK = new Movie("The Hulk", Movie.CHILDREN);
  private static final Movie IRON_MAN = new Movie("Iron Man 4", Movie.NEW_RELEASE);
  private static final Movie SPIDER_MAN = new Movie("Spiderman", Movie.REGULAR)
  private Customer customer

  void setup() {
    customer = new Customer("fred")
  }

  def "statement prints a summary of all owed movies with their amount as well as earned renter points"() {
    given:
    rent(THE_HULK, 2)
    rent(SPIDER_MAN, 1)
    rent(IRON_MAN, 3)
    when:
    String actualStatement = customer.statement()
    then:
    actualStatement == """Rental record for fred
	The Hulk	1.5
	Spiderman	2.0
	Iron Man 4	9.0
Amount owed is 12.5
You earned 4 frequent renter points"""
  }

  protected rent(Movie movie, int daysRented) {
    customer.addRental(new Rental(movie, daysRented))
  }

}
