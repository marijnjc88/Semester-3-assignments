package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodonTest {

    // Tests whether the toString function of the Codon works
    @Test
    void testToString() {
        // Expected value
        String expected = "TCG";

        // Actual value
        Codon codon = new Codon(Nucleotide.T, Nucleotide.C, Nucleotide.G);
        String actual = codon.toString();

        // Comparison
        assertEquals(expected, actual);
    }

    // Tests whether every constructor gives the same toString result when given the correct values
    @Test
    void testConstructors() {
        // Expected value
        String expected = "TCG";

        // Actual values
        Codon nucleotideConstructor = new Codon(Nucleotide.T, Nucleotide.C, Nucleotide.G);
        String actualNucleotide = nucleotideConstructor.toString();

        Codon charConstructor = new Codon('T', 'C', 'G');
        String actualChar = charConstructor.toString();

        Codon stringConstructor = new Codon("TCG");
        String actualString = stringConstructor.toString();

        // Comparison
        assertEquals(expected, actualNucleotide);
        assertEquals(expected, actualChar);
        assertEquals(expected, actualString);
    }

    // Tests whether the Nucleotide constructor correctly assigns every value to the right fields
    @Test
    void testNucleotideConstructor() {
        // Expected values
        Nucleotide expected1 = Nucleotide.A;
        Nucleotide expected2 = Nucleotide.G;
        Nucleotide expected3 = Nucleotide.T;

        // Actual values
        Codon codon = new Codon(Nucleotide.A, Nucleotide.G, Nucleotide.T);
        Nucleotide actual1 = codon.getFirst();
        Nucleotide actual2 = codon.getSecond();
        Nucleotide actual3 = codon.getThird();

        // Comparison
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // Tests whether the char constructor correctly assigns every value to the right fields
    @Test
    void testCharConstructor() {
        // Expected values
        Nucleotide expected1 = Nucleotide.C;
        Nucleotide expected2 = Nucleotide.A;
        Nucleotide expected3 = Nucleotide.G;

        // Actual values
        Codon codon = new Codon('C', 'A', 'G');
        Nucleotide actual1 = codon.getFirst();
        Nucleotide actual2 = codon.getSecond();
        Nucleotide actual3 = codon.getThird();

        // Comparison
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // Tests whether the String constructor correctly assigns every value to the right fields
    @Test
    void testStringConstructor() {
        // Expected values
        Nucleotide expected1 = Nucleotide.T;
        Nucleotide expected2 = Nucleotide.C;
        Nucleotide expected3 = Nucleotide.A;

        // Actual values
        Codon codon = new Codon("TCA");
        Nucleotide actual1 = codon.getFirst();
        Nucleotide actual2 = codon.getSecond();
        Nucleotide actual3 = codon.getThird();

        // Comparison
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}