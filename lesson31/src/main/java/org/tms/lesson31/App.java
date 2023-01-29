package org.tms.lesson31;

import org.tms.lesson31.service.SearchService;

public class App {

    private static final SearchService searchService = new SearchService();

    public static void main(String[] args) {
//1
        Director director = new Director("Alexey", "Georgievich", 10);

        Employee worker = new Worker("Vas'ka", "Slesarev", 5);
        Employee worker2 = new Worker("Pet'ka", "Stolyarov", 15);

        System.out.println(worker);
        System.out.println(worker2);
//2
        director.employeeAppointment(worker, worker2);

        System.out.println(director);
//3
        Director director2 = new Director("Sergey", "Petrovich", 12);
        Employee worker3 = new Worker("Pashka", "Svarshikov", 8);

        director2.employeeAppointment(worker3);

        director.employeeAppointment(director2);

        System.out.println(director);
//4
        System.out.println(searchService.search(director, "Svarshikov"));
    }
}
