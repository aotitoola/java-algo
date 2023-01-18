package b.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    // Naive Solution
    // Pick a character and check through the entire string to see if there is another occurrence
    // we'll have to use two for-loops
    // Time Complexity: O (n^2)
    // Space Complexity: O (1)
    // ** does not work for every input
    public int searchString(String s) {

        // Better Approach
        // Use a HashMap
        // Create a counter using the hashMap
        // then go through the items again to see which ones occur more than once
        // i.e. build hash map : character and how often it appears

        // Time Complexity: O(n)
        // Space Complexity: O(1) - because English Alphabet contains 26 letters

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        // find the index
        for (int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
