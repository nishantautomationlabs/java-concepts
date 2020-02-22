package com.nal.generics;

/**
 * Created by nishant on 20/02/20.
 */
public class GenericsInheritance {

    public static void main(String[] args) {
        //Inherited class can be assigned to base class but the same is does not works for Generics
        BaseClass baseClass = new CustomClass();

        GenericClass<String> genericClass1 = new GenericClass<>();

//        Compilation exception since GenericClass<String> is not a GenericClass<Object>
//        GenericClass<Object> genericClass2 = genericClass1;

        // MyClass<T> parent is Object
        Object obj = genericClass1;
    }
}
