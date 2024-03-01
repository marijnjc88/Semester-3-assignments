package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AminoacidTest {
    // Tests whether Aminoacid.isPresent returns false when null is passed as codonSequence
    @Test
    void testIsPresent_SequenceIsNull() {
        Aminoacid aminoacid = new Aminoacid(Set.of(new Codon("ACG")));
        boolean actual = aminoacid.isPresent(null);

        // Compare boolean value
        assertFalse(actual);
    }

    // Tests whether Aminoacid.isPresent returns false when an empty list is passed as codonSequence
    @Test
    void testIsPresent_SequenceIsEmpty() {
        Aminoacid aminoacid = new Aminoacid(Set.of(new Codon("ACG")));
        boolean actual = aminoacid.isPresent(Collections.emptyList());

        // Compare boolean value
        assertFalse(actual);
    }

    // Tests whether Aminoacid.isPresent returns false when the passed codonSequence
    // Does not contain a codon that can be translated to the Amino acid
    @Test
    void testIsPresent_DoesNotContainAminoacid() {
        Aminoacid aminoacid = new Aminoacid(Set.of(new Codon("ACG")));
        List<Codon> sequence = new ArrayList<>();
        sequence.add(new Codon("GCA"));
        sequence.add(new Codon("AAA"));
        boolean actual = aminoacid.isPresent(sequence);

        // Compare boolean value
        assertFalse(actual);
    }

    // Tests whether Aminoacid.isPresent returns true when the passed codonSequence
    // Does contain a codon that can be translated to the Amino acid
    @Test
    void testIsPresent_DoesContainAminoacid() {
        Aminoacid aminoacid = new Aminoacid(Set.of(new Codon("ACG")));
        List<Codon> sequence = new ArrayList<>();
        sequence.add(new Codon("CAG"));
        sequence.add(new Codon("TTT"));
        sequence.add(new Codon("ACG"));
        boolean actual = aminoacid.isPresent(sequence);

        // Compare boolean value
        assertTrue(actual);
    }

    // Tests whether Aminoacid.getPossibleCodons returns an empty list of possible Codons
    // When initialized with null as the possibleCodons
    @Test
    void testGetPossibleCodons_PossibleCodonsIsNull() {
        // Expected value
        int expectedCount = 0;

        // Actual values
        Aminoacid aminoacid = new Aminoacid(null);
        Set<Codon> actualPossibleCodons = aminoacid.getPossibleCodons();
        int actualCount = actualPossibleCodons.size();

        // Comparison
        assertNotNull(actualPossibleCodons);
        assertEquals(expectedCount, actualCount);
    }

    // TODO: ask how this works?
    @Test
    void testGetPossibleCodons() {
        Aminoacid aminoacid = new Aminoacid(Set.of(new Codon("AAA")));
        Set<Codon> possibleCodons = aminoacid.getPossibleCodons();

        // Comparison
        assertThrows(UnsupportedOperationException.class,
                () -> possibleCodons.add(new Codon("GGG")));
    }
}