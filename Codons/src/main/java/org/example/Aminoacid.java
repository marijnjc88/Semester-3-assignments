package org.example;

import java.util.*;

public class Aminoacid {
    // All codons that can be translated to this Amino acid
    private Set<Codon> possibleCodons;

    // Constructor
    public Aminoacid(Set<Codon> possibleCodons) {
        this.possibleCodons = possibleCodons;
    }

    // Check if codonSequence is present in possibleCodons set
    public boolean isPresent(Collection<Codon> codonSequence) {
        // If codonSequence has no contents, return false
        if (codonSequence == null || codonSequence.isEmpty()) {
            return false;
        }

        // Check if one of the codons from the codonSequence can be translated to this Amino acid
        for (Codon c : codonSequence) {
            if (possibleCodons.contains(c)) {
                return true;
            }
        }

        return false;
    }

    // Get all possible codons that translate to this Amino acid
    public Set<Codon> getPossibleCodons() {
        if (this.possibleCodons == null) {
            return Collections.emptySet();
        }

        return Collections.unmodifiableSet(this.possibleCodons);
    }
}
