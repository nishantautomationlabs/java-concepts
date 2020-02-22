package com.nal.javasort;

/**
 * Created by nishant on 19/02/20.
 */
public class CustomSortUsingComparable implements Comparable<CustomSortUsingComparable> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public CustomSortUsingComparable(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(CustomSortUsingComparable emp) {
        return (this.id - emp.id);
    }

    @Override
    //print formatted Employee details
    public String toString() {
        return "[id= " + this.id + ", name= " + this.name + ", age= " + this.age + ", salary= " + this.salary + "]";
    }

}
