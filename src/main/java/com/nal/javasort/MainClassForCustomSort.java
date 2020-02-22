package com.nal.javasort;

import java.util.Arrays;

/**
 * Created by nishant on 19/02/20.
 */
public class MainClassForCustomSort {

    public static void main(String[] args) {
        CustomSortUsingComparable[] empArr = new CustomSortUsingComparable[4];
        empArr[0] = new CustomSortUsingComparable(3, "Avik", 27, 1000);
        empArr[1] = new CustomSortUsingComparable(2, "Ashish", 29, 2000);
        empArr[2] = new CustomSortUsingComparable(1, "Nishant", 35, 3000);
        empArr[3] = new CustomSortUsingComparable(4, "Arnab", 28, 4000);

        //sorting employees array using Comparable interface
        Arrays.sort(empArr);
        System.out.println("Sorted Employees list Using Comparable:\n" + Arrays.toString(empArr));
        System.out.println("------------------------------------------------------------------------------------");

        CustomSortUsingComparator[] employees = new CustomSortUsingComparator[4];
        employees[0] = new CustomSortUsingComparator(3, "Avik", 27, 1000);
        employees[1] = new CustomSortUsingComparator(2, "Ashish", 29, 2000);
        employees[2] = new CustomSortUsingComparator(1, "Nishant", 35, 3000);
        employees[3] = new CustomSortUsingComparator(4, "Arnab", 28, 4000);

        //sorting employees array using Comparator class implementing Comparator interface
        Arrays.sort(employees, new CustomComparator());
        System.out.println("Sorted Employees list Using Comparator:\n" + Arrays.toString(employees));
        System.out.println("------------------------------------------------------------------------------------");

        CustomSortUsingComparator[] empArr2 = new CustomSortUsingComparator[4];
        empArr2[0] = new CustomSortUsingComparator(3, "Avik", 27, 1000);
        empArr2[1] = new CustomSortUsingComparator(2, "Ashish", 29, 2000);
        empArr2[2] = new CustomSortUsingComparator(1, "Nishant", 35, 3000);
        empArr2[3] = new CustomSortUsingComparator(4, "Arnab", 28, 4000);

        //sorting employees array using static Comparator class in the Employee class
        Arrays.sort(empArr2, CustomSortUsingComparator.IdComparator);
        System.out.println("\"Sorted Employees list by Id Using Comparator:\n" + Arrays.toString(empArr2));

        Arrays.sort(empArr2, CustomSortUsingComparator.NameComparator);
        System.out.println("\"Sorted Employees list by Name Using Comparator:\n" + Arrays.toString(empArr2));

        ComparableWithComparator[] empArr3 = new ComparableWithComparator[4];
        empArr3[0] = new ComparableWithComparator(3, "Avik", 28, 1000);
        empArr3[1] = new ComparableWithComparator(2, "Ashish", 29, 2000);
        empArr3[2] = new ComparableWithComparator(1, "Nishant", 35, 3000);
        empArr3[3] = new ComparableWithComparator(4, "Arnab", 28, 4000);

        System.out.println("------------------------------------------------------------------------------------");
        //will sort by ID using comparable
        Arrays.sort(empArr3);
        System.out.println("\"Sorted Employees list by Id Using Comparator:\n" + Arrays.toString(empArr3));

        //Will sort by name as comparator is used
        Arrays.sort(empArr3, ComparableWithComparator.NameComparator);
        System.out.println("\"Sorted Employees list by Name Using Comparator:\n" + Arrays.toString(empArr3));

        Arrays.sort(empArr3, ComparableWithComparator.AgeComparator);
        System.out.println("\"Sorted Employees list by Age Using Comparator:\n" + Arrays.toString(empArr3));

        Arrays.sort(empArr3, ComparableWithComparator.SalaryComparator);
        System.out.println("\"Sorted Employees list by Salary Using Comparator:\n" + Arrays.toString(empArr3));

        //Compare based on Age and if age is same compare based on Name -- Lamda expression anonymous class
        Arrays.sort(empArr3, (e1, e2) -> {
            if(e1.getAge() != e2.getAge())
                return e1.getAge() - e2.getAge();
            else
                return e1.getName().compareTo(e2.getName());
        });
        System.out.println("\"Sorted Employees list by Age and Name:\n" + Arrays.toString(empArr3));
    }
}
