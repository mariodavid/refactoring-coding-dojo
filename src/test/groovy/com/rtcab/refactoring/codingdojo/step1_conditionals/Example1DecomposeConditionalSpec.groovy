package com.rtcab.refactoring.codingdojo.step1_conditionals

import spock.lang.Specification

import java.time.LocalDate

class Example1DecomposeConditionalSpec extends Specification {

    Example1DecomposeConditional sut


    def setup() {
        sut = new Example1DecomposeConditional(
                summerRate: 100,
                winterRate: 200,
                winterServiceCharge: 50
        )
    }

    def "for october summer rate will be charged"() {
        expect:
        sut.getCharge(date(10,25), 2) == (2 * 200 + 50)
    }


    def "for october winter rate will be charged"() {
        expect:
        sut.getCharge(date(7,13), 2) == (2 * 100)
    }


    def "on 21.6 summer rate will be charged"() {
        expect:
        sut.getCharge(date(6,21), 2) == (2 * 100)
    }

    def "on 23.9 summer rate will be charged"() {
        expect:
        sut.getCharge(date(9,23), 2) == (2 * 100)
    }

    def "on 24.9 winter rate will be charged"() {
        expect:
        sut.getCharge(date(9,24), 2) == (2 * 200 + 50)
    }

    protected LocalDate date(int month, int dayOfMonth) {
        LocalDate.of(2018, month, dayOfMonth)
    }
}
