## Introduction Example: Movie Rental - Customer.statement()

### Refactoring walkthrough


#### 1. extract method `Customer.amountFor(Rental rental)`

Before:

```
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
```

After:

```
double amount = 0;
thisAmount = amountFor(rental, amount);
```

1.1 extract method (IDEA)
1.2 IDEA tries to pass in amount. Let it happen
1.3 compile && test
1.4 create another method without this parameter and delegate to the original one with setting the value to `0`
1.5 replace callers with not passing amount in and with that use the new method
1.6 compile && test
1.7 inline method `amountFor(Rental rental, double amount)` into `amountFor(Rental rental)`
1.8 compile && test
1.9 DONE! 


After 1.9:

```
double amount = amountFor(rental);
```



#### 2. rename variable - `amount` --> `result`

Rename the variable within the extracted method `amountFor`

Before:

```
  private double amountFor(Rental rental) {
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
    return amount;
  }
```

After:

```
  private double amountFor(Rental rental) {
    double result = 0;
    switch (rental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (rental.getDaysRented() > 2)
          result += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        result += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDREN:
        result += 1.5;
        if (rental.getDaysRented() > 3)
          result += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return result;
  }
```

3. move method `Customer.amountFor` --> `Rental.getCharge`

Before:

```
class Customer {
  
  // ...
  
  private double amountFor(Rental rental) {
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
    return amount;
  }
}
```

After:

```

public class Rental {

  // ...

  double getCharge() {
    double result = 0;
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (getDaysRented() > 2)
          result += (getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        result += getDaysRented() * 3;
        break;
      case Movie.CHILDREN:
        result += 1.5;
        if (getDaysRented() > 3)
          result += (getDaysRented() - 3) * 1.5;
        break;
    }
    return result;
  }
}
```

4. replace temp with query `double amount = rental.getCharge()`


Before:

```

  // ...

  public String statement() {

    for (Rental rental : rentals) {
      double amount = rental.getCharge();

      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

      totalAmount += amount;
    }

  }
```

After:

```
class Customer {
  
  // ...
  
  
  public String statement() {

    for (Rental rental : rentals) {
      // show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";

      totalAmount += rental.getCharge();
    }
  }`
}
```

4.1 IDEA: inline variable: `double amount`

5. extract method `getFrequentRenterPoints` move method to `Rental`

6. remove temp `totalAmount` with Query `getTotalAmount()`
6.1 split for loop into two for loops (one for `totalAmount, one for `result` & `frequentRenterPoints`) 
6.2 extract method `getTotalAmount()`
6.3 inline variable `totalAmount`

7. remove temp `frequentRenterPoints` with Query `getFrequentRenterPoints()` 
7.1 split for loop into two for loops (one for `result`, one for `frequentRenterPoints`) 
7.2 extract method `getFrequentRenterPoints()`
7.3 inline variable `frequentRenterPoints`

8. replace type code with state / strategy: `Rental.getCharge()` --> `Movie.getCharge(int daysRented)`
8.1 create variable of `getDaysRented()` into `daysRented = getDaysRented()`
8.2 extract method (without `daysRented`): `getCharge(int daysRented)`
8.3 move method `Rental.getCharge(int daysRented)` --> `Movie.getCharge(int daysRented)`

9. replace type code with state / strategy: `Rental.getFrequentRenterPoints()` --> `Movie.getFrequentRenterPoints(int daysRented)`
8.1 create variable of `getFrequentRenterPoints()` into `daysRented = getDaysRented()`
8.2 extract method (without `daysRented`): `getFrequentRenterPoints(int daysRented)`
8.3 move method `Rental.getFrequentRenterPoints(int daysRented)` --> `Movie.getFrequentRenterPoints(int daysRented)`

9. replace conditional with polymorphism `Movie.getCharge` -->  `Price.getCharge`
9.1 create Price class
9.2 Movie constructor: use `setPriceCode`
9.3 create classes `Price`, `RegularPrice`, `ChildrenPrice` and `NewReleasePrice`
9.4 create method `abstract getPriceCode` for `Price`
9.5 return price codes in subclasses (`Movie.REGULAR` e.g.)
9.6 create `Price price` field in `Movie`
9.6 switch `Movie.setPriceCode` to setting also `price` field:

```
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
    this.priceCode = priceCode;
  }
```
9.7 delegate `Movie.getPriceCode()` to `price.getPriceCode()`
9.8 remove field `priceCode` from `Movie`
9.9 copy method `Movie.getCharge(int daysRented)` to `Price.getCharge(int daysRented)`

9.10 override `getCharge(int daysRented)` in `RegularPrice`
9.11 remove case for `Movie.REGULAR` in switch case of `Price.getCharge(int daysRented)`
9.10 override `getCharge(int daysRented)` in `ChildrenPrice`
9.11 remove case for `Movie.CHILDREN` in switch case of `Price.getCharge(int daysRented)`
9.10 override `getCharge(int daysRented)` in `NewReleasePrice`
9.11 remove case for `Movie.NEW_RELEASE` in switch case of `Price.getCharge(int daysRented)`
9.12 make `Price.getCharge(int daysRented)` abstract
