package org.tms.lesson31.service;

import org.tms.lesson31.Director;
import org.tms.lesson31.Employee;

import java.util.List;

public class SearchService {

    public Employee search(Director director, String searchTarget) {

        List<Employee> subordinates = director.getSubordinates();

        Employee desiredEmployee = null;

        for (Employee subordinate : subordinates) {
            if (subordinate.getSurname().equals(searchTarget)) {
                desiredEmployee = subordinate;
                break;
            } else if (subordinate instanceof Director) {
                desiredEmployee = search((Director) subordinate, searchTarget);
            }
        }
        if (desiredEmployee == null) {
            throw new RuntimeException("The employee hasn't been found");
        }
        return desiredEmployee;
    }

}
