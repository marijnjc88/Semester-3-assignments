package org.example;

import lombok.Getter;
import lombok.EqualsAndHashCode;

@Getter
@EqualsAndHashCode
public class Codon {
    // The 3 nucleotides the Codon consists of
    private final Nucleotide first;
    private final Nucleotide second;
    private final Nucleotide third;

    // Constructor 1
    // Set first, second and third to the given Nucleotides
    public Codon(Nucleotide first, Nucleotide second, Nucleotide third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Constructor 2
    // Translate the given nucleotides from char to the enum Nucleotide and pass them to constructor 1
    public Codon(char first, char second, char third) {
        this(
                Nucleotide.valueOf(String.valueOf(first)),
                Nucleotide.valueOf(String.valueOf(second)),
                Nucleotide.valueOf(String.valueOf(third))
        );
    }

    // Constructor 3
    // Take a string of 3 characters, and pass each character as one of the variables for constructor 2
    public Codon(String nucleotides)
    {
        this(
                nucleotides.charAt(0),
                nucleotides.charAt(1),
                nucleotides.charAt(2)
        );
    }

    // Return the Nucleotides of this Codon instance as a string
    @Override
    public String toString() {
        return "" + first + second + third;
    }
}
