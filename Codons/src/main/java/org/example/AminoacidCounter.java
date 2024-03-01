package org.example;

import java.util.*;

public class AminoacidCounter {
    // Counts how often an aminoacid is found inside a sequence
    public Map<Aminoacid, Integer> countAminoacids(List<Codon> sequence, Set<Aminoacid> aminoacids) {
        Map<Aminoacid, Integer> countPerAminoacid = new HashMap<>();

        // Loop through all aminoacids you want to find
        for(Aminoacid a : aminoacids) {
            int numberOfAppearances = 0;
            // Loop through all Codons in the sequence
            for(Codon c : sequence) {
                // If the Codon is in the aminoacids list of possible Codons, increment numberOfAppearances
                if (a.getPossibleCodons().contains(c)) numberOfAppearances++;
            }
            // Add the number of appearances for this aminoacid to the return map
            countPerAminoacid.put(a, numberOfAppearances);
        }

        return countPerAminoacid;
    }
}
