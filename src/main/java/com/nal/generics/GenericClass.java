package com.nal.generics;

/**
 * Created by nishant on 20/02/20.
 */
public class GenericClass<T> {

    private T t;

    public T getValue() {
        return t;
    }

    public void setValue(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericClass<String> stringGenericsExample = new GenericClass<>();
        stringGenericsExample.setValue("saas");
        System.out.println(stringGenericsExample.getValue());

        GenericClass<Integer> integerGenericsExample = new GenericClass<>();
        integerGenericsExample.setValue(1);
        System.out.println(integerGenericsExample.getValue());

        GenericClass genericsExample = new GenericClass();
        genericsExample.setValue("asas");
        System.out.println(genericsExample.getValue());
        genericsExample.setValue(3);
        System.out.println(genericsExample.getValue());
    }
}
