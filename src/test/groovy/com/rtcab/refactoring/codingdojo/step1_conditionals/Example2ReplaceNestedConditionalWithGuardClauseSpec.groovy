package com.rtcab.refactoring.codingdojo.step1_conditionals

import spock.lang.Specification


class Example2ReplaceNestedConditionalWithGuardClauseSpec extends Specification {


    def 'dead pay amount is 200'() {
        given:
        def sut = new Example2ReplaceNestedConditionalWithGuardClause(dead: true)

        expect:
        sut.getPayAmount() == 200
    }


    def 'separated pay amount is 150'() {
        given:
        def sut = new Example2ReplaceNestedConditionalWithGuardClause(separated: true)

        expect:
        sut.getPayAmount() == 150
    }


    def 'retired pay amount is 80'() {
        given:
        def sut = new Example2ReplaceNestedConditionalWithGuardClause(retired: true)

        expect:
        sut.getPayAmount() == 80
    }

    def 'normal pay amount is 40'() {
        given:
        def sut = new Example2ReplaceNestedConditionalWithGuardClause()

        expect:
        sut.getPayAmount() == 40
    }


}
