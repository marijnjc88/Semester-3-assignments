package org.example;

public class Bird extends Pet {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp");
    }
}
