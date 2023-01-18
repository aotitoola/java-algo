package b.arrays;

public class ValidAnagram {

    // Approach 1: Naive, Brute Force Solution
    // Sort both arrays and then compare them
    // check if the length of the 2 arrays is the same

    // Time Complexity: O (n log n)
    // Sorting costs O (n log n)
    // Comparing the arrays costs O (n)
    //
    // Space Complexity: O (n)
    // Sorting costs O (n log n)
    // Comparing the arrays costs O (1) space

    //    public boolean isAnagram(String s, String t) {
    //        // different strength strings cannot be anagrams of each other
    //        if (s.length() != t.length()) {
    //            return false;
    //        }
    //
    //        // sort both arrays
    //        char[] schar = s.toCharArray();
    //        char[] tchar = t.toCharArray();
    //
    //        Arrays.sort(schar);
    //        Arrays.sort(tchar);
    //
    //        return Arrays.equals(schar, tchar);
    //    }

    // Approach 2:
    // initial order does not matter
    // Frequencies matter
    // There are only 26 letters
    // We use hash tables

    // using the knowledge of ASCII, we subtract 'a' from the ith character
    // before incrementing
    // lowercase ASCII values for English letters go from 97 for 'a' up to 122 for 'z'
    // subtracting 'a' allows us to map the ASCII values of lowercase English letters into the range 0 - 26
    // once we have the right index, we increase the count

    // compare both arrays
    // loop/count from 0-26 and if there is a dissimilar count, we return false

    // Time Complexity: O (n + k), where K is 26
    // Space Complexity: O (k)

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sCounter = new int[26];
        int[] tCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCounter[s.charAt(i) - 'a']++;
            tCounter[t.charAt(i) - 'a']++;
        }

        for (int i= 0; i < 26; i++) {
            if (sCounter[i] != tCounter[i]) {
                return false;
            }
        }

        return true;
    }

}
