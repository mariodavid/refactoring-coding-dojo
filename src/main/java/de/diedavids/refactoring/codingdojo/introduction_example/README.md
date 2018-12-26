## Introduction Example: Movie Rental - Customer.statement()

The first example deals with the domain of Movie rental. The object model contains the classes `Movie`, `Rental` and `Customer`.

`Customer` has a method called `statement` which prints out a overview on the customers amount owed as well as its rentings.

The result of the method looks like this:

```
Rental record for fred
	The Hulk	1.5
	Spiderman	2.0
	Iron Man 4	9.0
Amount owed is 12.5
You earned 4 frequent renter points
```

### Current situation

The current implementation of the method looks like this:

```

public class Customer {

  // ...
  
  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;

    String result = "Rental record for " + getName() + "\n";
    for (Rental rental : rentals) {
      double amount = 0;
      switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          amount += 2;
          if (rental.getDaysRented() > 2)
            amount += (rental.getDaysRented() - 2) * 1.5;
          break;
        case Movie.NEW_RELEASE:
          amount += rental.getDaysRented() * 3;
          break;
        case Movie.CHILDREN:
          amount += 1.5;
          if (rental.getDaysRented() > 3)
            amount += (rental.getDaysRented() - 3) * 1.5;
          break;
      }

      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
        frequentRenterPoints++;

      // show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

      totalAmount += amount;
    }

    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

    return result;
  }
}
```

The code contains some problematic code smells according Chapter 3 of the Refactoring book:

* Long method
* Feature envy
* Primitive obsession
* Switch Statements
* Inappropriate Intimacy
* Comment

as well as some other downsides. E.g. it requires to introduce code duplication in case we want to render a HTML statement instead of an text based one.  

### Possible refactorings

The following refactorings can be applied, to remove some of the problems of the implementation:

1. extract method
2. rename variable
3. move method
4. replace temp with query
5. replace type code with state / strategy
6. replace conditional with polymorphism