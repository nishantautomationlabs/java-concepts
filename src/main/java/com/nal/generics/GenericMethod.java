package com.nal.generics;

/**
 * Created by nishant on 20/02/20.
 */
public class GenericMethod {

    public static void main(String[] args) {
        GenericClass<String> genericClass1 = new GenericClass<>();
        genericClass1.setValue("Nishant");

        GenericClass<String> genericClass2 = new GenericClass<>();
        genericClass2.setValue("Singh");

//        Explicit Argument type
        boolean isEqual1 = GenericMethod.<String>isEqual(genericClass1, genericClass2);
//        Argument type inferred from argument [Type inference]
        boolean isEqual2 = GenericMethod.isEqual(genericClass1, genericClass2);
        System.out.println("Equals: " + isEqual1);
        System.out.println("Equals: " + isEqual2);

        GenericMethod.equals("sa", "sa");
        GenericMethod.equals(2, 2);
        GenericMethod.equals(new CustomClass(), new CustomClass());

        GenericClass<Object> genericObj = GenericMethod.getGenericObj();

        GenericMethod.compare(new CustomComparableClass(), new CustomComparableClass());

        //Will throw compile time error as AnotherCustomClass does not implements Comparable
//        GenericMethod.compare(new AnotherCustomClass(), new AnotherCustomClass());

        CustomClass aClass = new CustomClass();
        aClass.value = 5;
        GenericMethod.printValue(aClass);
        GenericMethod.printValue(aClass);

        //Will throw error as AnotherCustomClass does not extend BaseClass
//        GenericMethod.printValue(new AnotherCustomClass());

        CustomClass2 customClass2 = new CustomClass2();
        GenericMethod.printValue2(customClass2);

//        Will throw error as aClass does not implement BaseInterface
//        GenericMethod.printValue2(aClass);
    }

//    Method to accept generic objects
//    <T> in method signature shows generic type used in method
    private static <T> boolean isEqual(GenericClass<T> obj1, GenericClass<T> obj2) {
        return obj1.getValue().equals(obj2.getValue());
    }

    private static <T> boolean equals(T obj1, T obj2) {
        return obj1.equals(obj2);
    }

//    Method signature to return generic type object
    private static <T> GenericClass<T> getGenericObj() {
        return new GenericClass<T>();
    }


    private static <T extends Comparable<T>> boolean compare(T t1, T t2) {
        return t1.equals(t2);
    }

    private static <T extends BaseClass> void printValue(T t1) {
        System.out.println(t1.value);
    }

    private static <T extends BaseClass & BaseInterface & BaseInterface2> void printValue2(T t1) {
        System.out.println(t1.value);
    }


}
