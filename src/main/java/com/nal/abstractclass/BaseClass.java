package com.nal.abstractclass;

/**
 * Created by Nishant on 03-11-2018.
 */
abstract public class BaseClass { //Cannot be instantiated

    private String variable;

    abstract void methodToBeImplementedByChild(); //abstract method to be implemented by all child classes

    protected void methodReadyToBeUsedByChild() //non abstract method defined in the abstract class
    {
        System.out.println("method predefined");
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
