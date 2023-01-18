package b.searchingAndSorting;

import java.util.*;

public class SortCharactersByFrequency {

    // Strings are Immutable, meaning once it is created, we cannot modify it. We can only create a new string
    // We should be careful not to convert an O(n) algorithm to an O(n^2) problem

    // String a = "Hello ";
    // a += "World

    // The code above creates a String called 'a'
    // then sets 'a' to a new string. A new string is made and the reference to the old string is thrown away
    // 'a' is not modified

    // if we loop through a string to reverse it for example
    // a new string is created when we append a character to the result
    // this will cost O(n^2) time using this approach to reverse the string
    // because creating a new string by concatenation has a cost of O(n)

    // The solution is to use a StringBuilder, this is because all characters that will be eventually converted
    // are collected first so that only one string is created
    // just like adding an item at the end of an array coses O(1)
    // cost of insertion into a string builder will be O(n)
    // cost of converting to a string is also O(n)



    // APPROACH: USE HASHMAP & SORTING
    // We use a HashMap to count how many times each character occurs in the string
    // We then take a copy of the keys from the HashMap and sort them by frequency using a Comparator

    // After this step, we can then use a stringBuilder and then iterate over the list of sorted characters
    // (sorted by frequency). We check the hashmap to know how many of each character to append to the stringBuilder

    public String frequencySort(String s) {

        // STEP 1: count the occurrences
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // We create a list of the keys and sort them by frequency
        List<Character> characterList = new ArrayList<>(freqMap.keySet());
        characterList.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        // Collections.sort(characterList, (a, b) -> freqMap.get(b) - freqMap.get(a));

        // now, we convert the frequencies into a string with a StringBuilder
        StringBuilder sb = new StringBuilder();
        for (char c: characterList) {
            int count = freqMap.get(c);
            for (int i =0 ; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Time Complexity: O (n log n) OR (n + k log k)
    // Space Complexity: O(n)
    // HashMap uses O(k) space
    // StringBuilder uses O(n) space. This definitely supersedes O(k)



    // We can improve this algorithm using Bucket Sort
    // BucketSort is the sorting algorithm where items are placed at Array indexes based on their values
    // (the indexes are called "buckets"). For this problem, we'll need to have a List of characters at each index.

    // Time Complexity: O (N)
    // Space Complexity O (N)

}
