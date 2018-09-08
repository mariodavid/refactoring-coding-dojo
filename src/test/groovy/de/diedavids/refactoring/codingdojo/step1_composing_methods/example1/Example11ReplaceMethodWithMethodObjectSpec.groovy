package de.diedavids.refactoring.codingdojo.step1_composing_methods.example1

import de.diedavids.refactoring.codingdojo.step1_composing_methods.example1.Example11ReplaceMethodWithMethodObject
import spock.lang.Specification

class Example11ReplaceMethodWithMethodObjectSpec extends Specification {

    Example11ReplaceMethodWithMethodObject sut

    def setup() {
        sut = new Example11ReplaceMethodWithMethodObject()
    }

    def "gamma returns 56956 for three items in 2018 for 4 input values"() {

        when:
        def actualGamma = sut.gamma(4, 3, 2018)

        then:
        actualGamma == 56956
    }

    def "gamma returns 4336 for three items in year 54 for 10 input values"() {

        when:
        def actualGamma = sut.gamma(10, 3, 54)

        then:
        actualGamma == 4336
    }

    def "gamma returns a negative value for 0 items in year 1999 for -1 input values"() {

        when:
        def actualGamma = sut.gamma(-2, 0, 1999)

        then:
        actualGamma == -27510
    }
}
