package org.example;

public class Dog {
    // String with capital S
    private String name;

    public String getName() {
        return name;
    }

    // Functions with lower case first letter - camelCase, not PascalCase
    public void makeSound() {
        System.out.println("Woof");
    }

    // Override existing toString() method
    @Override
    public String toString() {
        return ""+name+" Barking";
    }

    // Constructor
    public Dog(String name) {
        this.name = name;
    }
}
