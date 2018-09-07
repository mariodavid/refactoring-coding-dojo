package com.rtcab.refactoring.codingdojo.conditionals

import spock.lang.Specification


class ReplaceNestedConditionalWithGuardClauseSpec extends Specification {


    def 'dead pay amount is 200'() {
        given:
        def sut = new ReplaceNestedConditionalWithGuardClause(dead: true)

        expect:
        sut.getPayAmount() == 200
    }


    def 'separated pay amount is 150'() {
        given:
        def sut = new ReplaceNestedConditionalWithGuardClause(separated: true)

        expect:
        sut.getPayAmount() == 150
    }


    def 'retired pay amount is 80'() {
        given:
        def sut = new ReplaceNestedConditionalWithGuardClause(retired: true)

        expect:
        sut.getPayAmount() == 80
    }

    def 'noremal pay amount is 40'() {
        given:
        def sut = new ReplaceNestedConditionalWithGuardClause()

        expect:
        sut.getPayAmount() == 40
    }

}
