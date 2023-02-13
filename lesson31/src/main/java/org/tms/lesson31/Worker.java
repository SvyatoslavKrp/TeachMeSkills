package org.tms.lesson31;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Worker extends Employee {

    private String name;
    private String surname;
    private int workExperience;
    private final Position position = Position.WORKER;

    @Override
    public double salaryCalc() {

        double salary = position.getBaseRate() * position.getCoef();

        return workExperience > 0 ?
                salary * workExperience :
                salary;

    }

    @Override
    public String toString() {

        return name + " " + surname + " has been working as a " + position + " " + workExperience + " years and has salary: " + salaryCalc();

    }
}
