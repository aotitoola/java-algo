package b.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    // Approach 1: Brute Force, Enumerating all the substrings
    // then use a Direct Access Table int[128] or HashSet to check the substrings
    // 3 for loops

    // Time Complexity: O(N^3)
    // Space Complexity - O(M) where M is the size of the Direct Access Table
    public int lengthOfLongestSubstringV1(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (checkIfLongest(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    boolean checkIfLongest(String s, int start, int end) {

        int[] chars = new int[128];

        for (int i = start; i < end; i++) {
            char c = s.charAt(i);

            // characters are mapped to numbers automatically (ASCII)
            chars[c]++;

            if (chars[c] > 1) return false;
        }

        return true;
    }


    // Approach 2: Sliding Window Approach: We use 2 pointers,
    // the right pointer to extend the window and the
    // left pointer to contract the window
    // both are initially at index 0
    // Time complexity: O(2N) worst case, both pointers moving = O(N)
    // Space Complexity: O(M) where M is the size of the Direct Access Table
    int lengthOfLongestSubstringV2(String s) {

        Map<Character, Integer> hashMap = new HashMap<>();

        int left = 0;
        int right = 0;

        int maxLength = 0;
        int n = s.length();

        while (right < n) {
            char r = s.charAt(right);
            hashMap.put(r, hashMap.getOrDefault(r, 0) + 1);
            maxLength = Math.max(maxLength, right - left + 1);

            // contracting the window, if the character at the right boundary appears more than once
            // we need to keep contracting the window until the left and right pointer are at the same
            // index and counter for the right pointer is back to 1
            while (hashMap.get(r) > 1) {
                char l = s.charAt(left);
                hashMap.put(l, hashMap.get(l) - 1);
                left++;
            }
            right++;
        }

        return maxLength;
    }



}
