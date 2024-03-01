package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void testToString() {
        String expected = "Dog Barking";

        Dog dog = new Dog("Dog");
        String actual = dog.toString();

        assertEquals(expected, actual);
    }
}