package de.diedavids.refactoring.codingdojo.step2_moving_features_between_objects.example1_move_method

import spock.lang.Specification
import spock.lang.Unroll

class AccountSpec extends Specification {

    Account sut

    def "overdraftCharge is 10.5 EUR for 7 days for regular accounts"() {
        given:
        sut = new Account(daysOverdrawn: 7, type: new AccountType(premium: false))

        expect:
        sut.overdraftCharge() == 12.25d
    }

    def "overdraftCharge is 3.5 EUR for 2 days for regular accounts"() {
        given:
        sut = new Account(daysOverdrawn: 2, type: new AccountType(premium: false))

        expect:
        sut.overdraftCharge() == 3.5d
    }

    @Unroll
    def "overdraftCharge is 10 EUR fixed for #daysOverdrawn day(s) for premium accounts"() {
        given:
        sut = new Account(daysOverdrawn: daysOverdrawn, type: new AccountType(premium: true))

        expect:
        sut.overdraftCharge() == overdraftCharge

        where:
        daysOverdrawn || overdraftCharge
        1 || 10d
        2 || 10d
        3 || 10d
        4 || 10d
        5 || 10d
        6 || 10d
        7 || 10d
    }


    def "overdraftCharge is 14.25 for 12 days for premium accounts"() {
        given:
        sut = new Account(daysOverdrawn: 12, type: new AccountType(premium: true))

        expect:
        sut.overdraftCharge() == 14.25d
    }

    def "overdraftCharge is 14.25 for 8 days for premium accounts"() {
        given:
        sut = new Account(daysOverdrawn: 8, type: new AccountType(premium: true))

        expect:
        sut.overdraftCharge() == 10.85d
    }
}
