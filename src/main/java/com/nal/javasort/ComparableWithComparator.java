package com.nal.javasort;

import java.util.Comparator;

/**
 * Created by nishant on 19/02/20.
 */
public class ComparableWithComparator implements Comparable<ComparableWithComparator>{

    private int id;
    private String name;
    private int age;
    private long salary;

    public ComparableWithComparator(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    //Using comparable to sort by ID , default behaviour if no comparator is used
    @Override
    public int compareTo(ComparableWithComparator o) {
        return this.id - o.id;

    }

    //Comparator to order based on Salary
    public static Comparator<ComparableWithComparator> SalaryComparator = new Comparator<>() {
        @Override
        public int compare(ComparableWithComparator e1, ComparableWithComparator e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    //Comparator to order based on Age
    public static Comparator<ComparableWithComparator> AgeComparator = (e1, e2) -> e1.getAge() - e2.getAge();

    //Comparator to order based on Name
    public static Comparator<ComparableWithComparator> NameComparator = Comparator.comparing(ComparableWithComparator::getName);

    @Override
    //print formatted CustomSortUsingComparator details
    public String toString() {
        return "[id= " + this.id + ", name= " + this.name + ", age= " + this.age + ", salary= " + this.salary + "]";
    }


}
