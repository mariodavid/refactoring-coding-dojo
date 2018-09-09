package de.diedavids.refactoring.codingdojo.step3_conditionals.example2_replace_nested_condition_with_guard_clauses


import spock.lang.Specification


class EmployeeSpec extends Specification {


    def 'dead pay amount is 200'() {
        given:
        def sut = new Employee(dead: true)

        expect:
        sut.getPayAmount() == 200
    }


    def 'separated pay amount is 150'() {
        given:
        def sut = new Employee(separated: true)

        expect:
        sut.getPayAmount() == 150
    }


    def 'retired pay amount is 80'() {
        given:
        def sut = new Employee(retired: true)

        expect:
        sut.getPayAmount() == 80
    }

    def 'normal pay amount is 40'() {
        given:
        def sut = new Employee()

        expect:
        sut.getPayAmount() == 40
    }


}
