package org.pondar.firstapp;

/**
 * Created by Liga on 15-02-2016.
 */
public class Person {

    private String name;
    private int age;

    public Person (String name, int age){
        System.out.println("Inside Constructor");
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return this.name + ", " + this.age +", " + (this.isOld() ? "is old" : "is young");
    }

    private boolean isOld() {
        if(age>40){
            return true;
        } else {
            return false;
        }
    }
}
