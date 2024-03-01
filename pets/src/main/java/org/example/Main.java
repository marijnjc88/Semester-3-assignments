package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Cat("Garfield"));
        pets.add(new Bird("Zazoe"));
        pets.add(new Cat("Mimous"));

        for (Pet pet : pets)
        {
            pet.makeSound();
        }
    }
}