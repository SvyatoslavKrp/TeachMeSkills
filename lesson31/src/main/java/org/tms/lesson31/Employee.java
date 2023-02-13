package org.tms.lesson31;

public abstract class Employee {

    private String name;
    private String surname;
    private int workExperience;
    private Position position;

    //я так понял, что имелось в виду то, что этот метод должен быть абстрактным
    public abstract double salaryCalc();

    public abstract String getSurname();

}
