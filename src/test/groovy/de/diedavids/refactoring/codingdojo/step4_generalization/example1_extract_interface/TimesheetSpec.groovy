package de.diedavids.refactoring.codingdojo.step4_generalization.example1_extract_interface

import spock.lang.Specification

class TimesheetSpec extends Specification {

    Timesheet sut

    def setup() {
        sut = new Timesheet()
    }


    def "charge calculates 30 for 1 day with a rate of 30 EUR and no special skill"() {
        given:
        def employee = regularEmployee(30)

        expect:
        sut.charge(employee, 1) == 30d
    }

    def "charge calculates 30 for 1 days with a rate of 30 EUR and a special skill"() {
        given:
        def employee = specialSkillEmployee(30)

        expect:
        sut.charge(employee, 1) == 31.5d
    }

    def "charge calculates 250 for 5 days with a rate of 50 EUR and no special skill"() {
        given:
        def employee = regularEmployee(50)

        expect:
        sut.charge(employee, 5) == (50 * 5)
    }

    protected Employee regularEmployee(int rate) {
        new Employee(specialSkill: false, rate: rate)
    }

    def "charge calculates 262.5 for 5 days with a rate of 50 EUR and a special skill"() {
        given:
        def employee = specialSkillEmployee(50)

        expect:
        sut.charge(employee, 5) == (double) (50 * 5 * 1.05)
    }

    protected Employee specialSkillEmployee(int rate) {
        new Employee(specialSkill: true, rate: rate)
    }


}
