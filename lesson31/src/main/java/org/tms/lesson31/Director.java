package org.tms.lesson31;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Director extends Employee {

    private final List<Employee> subordinates = new ArrayList<>();
    private final String name;
    private final String surname;
    private final int workExperience;
    private final Position position = Position.DIRECTOR;
    private final static double ONE_SUBORD_COEF = 0.5;

    public Director(String name, String surname, int workExperience) {
        this.name = name;
        this.surname = surname;
        this.workExperience = workExperience;
    }

    @Override
    public double salaryCalc() {

        double salary = position.getBaseRate() * position.getCoef();

        if (subordinates.size() > 0) {
            salary += subordinates.size() * position.getBaseRate() * ONE_SUBORD_COEF;
        }
        if (workExperience > 0) {
            salary *= workExperience;
        }

        return salary;

    }

    public void employeeAppointment(Employee... subordinate) {
        subordinates.addAll(List.of(subordinate));
    }

    @Override
    public String toString() {

        return name + " " + surname + " has been working as a " + position + " " + workExperience + " years and has salary: " + salaryCalc() + "\n" +
                "\tList of his employees: " + listFormat(subordinates);

    }

    private StringBuilder listFormat(List<Employee> employees) {

        if (employees.size() == 0) {
            return new StringBuilder().append("there are no subordinates");
        }

        StringBuilder builder = new StringBuilder("\n");

        for (Employee employee : employees) {
            builder.append("\t\t").append(employee).append("\n");
        }
        return builder;
    }

}
