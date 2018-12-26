package de.diedavids.refactoring.codingdojo.introduction_example

import spock.lang.Specification

class CustomerStatementAmountOwedSpec extends Specification {

  private static final Movie THE_HULK = new Movie("The Hulk", Movie.CHILDREN);
  private static final Movie IRON_MAN = new Movie("Iron Man 4", Movie.NEW_RELEASE);
  private static final Movie SPIDER_MAN = new Movie("Spiderman", Movie.REGULAR)
  private Customer customer

  void setup() {
    customer = new Customer("Manfred")
  }


  def "amount owed is 2 for a 'regular' movie rented for 2 days"() {
    given:
    rent(SPIDER_MAN, 2)
    expect:
    amountOwedIs(2.0)
  }

  def "amount owed is 9.5 for a 'regular' movie rented for 7 days"() {
    given:
    rent(SPIDER_MAN, 7)
    expect:
    amountOwedIs(9.5)
  }


  def "amount owed is 1.5 for a 'children' movie rented for 2 days"() {
    given:
    rent(THE_HULK, 2)

    expect:
    amountOwedIs(1.5)
  }

  def "amount owed is 3 for a 'children' movie rented for 4 days"() {
    given:
    rent(THE_HULK, 4)

    expect:
    amountOwedIs(3.0)
  }

  def "amount owed is 4.5 for a 'children' movie rented for 5 days"() {
    given:
    rent(THE_HULK, 5)

    expect:
    amountOwedIs(4.5)
  }

  def "amount owed is 3 for a 'new release' movie rented for 1 days"() {
    given:
    rent(IRON_MAN, 1)

    expect:
    amountOwedIs(3.0)
  }

  def "amount owed is 9 for a 'new release' movie rented for 3 days"() {
    given:
    rent(IRON_MAN, 3)

    expect:
    amountOwedIs(9.0)
  }



  def "amount owed sums the amounts of all rentals"() {
    given: 'regular movie for two days is amount: 2.0'
    rent(SPIDER_MAN, 2)

    and: 'children movie for three days is amount: 1.5'
    rent(THE_HULK, 2)

    and: 'new release movie for three days is amount: 9.0'
    rent(IRON_MAN, 3)


    expect:
    amountOwedIs(2.0 + 1.5 + 9.0)
  }


  protected rent(Movie movie, int daysRented) {
    customer.addRental(new Rental(movie, daysRented))
  }

  protected void amountOwedIs(BigDecimal expectedAmountOwed) {
    assert customer.statement().contains("Amount owed is " + expectedAmountOwed)
  }
}
