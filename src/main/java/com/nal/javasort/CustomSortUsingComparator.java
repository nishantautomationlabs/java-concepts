package com.nal.javasort;

import java.util.Comparator;

/**
 * Created by nishant on 19/02/20.
 */
public class CustomSortUsingComparator {

    private int id;
    private String name;
    private int age;
    private long salary;

    public CustomSortUsingComparator(int id, String name, int age, int salary) {
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

    //Comparator to order based on ID
    public static Comparator<CustomSortUsingComparator> IdComparator = new Comparator<>() {
        @Override
        public int compare(CustomSortUsingComparator e1, CustomSortUsingComparator e2) {
            return (int) (e1.getId() - e2.getId());
        }
    };

    //Comparator to order based on Salary
    public static Comparator<CustomSortUsingComparator> SalaryComparator = new Comparator<>() {
        @Override
        public int compare(CustomSortUsingComparator e1, CustomSortUsingComparator e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    //Comparator to order based on Age
    public static Comparator<CustomSortUsingComparator> AgeComparator = new Comparator<>() {
        @Override
        public int compare(CustomSortUsingComparator e1, CustomSortUsingComparator e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    //Comparator to order based on Name
    public static Comparator<CustomSortUsingComparator> NameComparator = new Comparator<>() {
        @Override
        public int compare(CustomSortUsingComparator e1, CustomSortUsingComparator e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    @Override
    //print formatted CustomSortUsingComparator details
    public String toString() {
        return "[id= " + this.id + ", name= " + this.name + ", age= " + this.age + ", salary= " + this.salary + "]";
    }

}
