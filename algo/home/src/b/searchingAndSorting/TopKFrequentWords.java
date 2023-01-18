package b.searchingAndSorting;

import java.util.*;

public class TopKFrequentWords {

    // Clarifying Questions:
    // Required to return a sorted list of strings, not in any order?
    // The frequency of a word is not guaranteed to be unique,
    // so have to break a tie when they have an identical frequency?

   // the primary challenge to solving this problem is to figure out a proper data structure
    // and algorithm to give a lexicographically (alphabetically) smaller string when breaking a tie in frequency
    // and return the list in correct order.

    // APPROACH 1: BRUTE FORCE
    // because we need to find which words are of higher frequencies, we just need to sort all words by their frequencies
    // and then return the first k words. The sorting is first by frequencies then lexicographically (by alphabets)

    // STEP 1: Count the frequency of each word and store the record and counts in a hashmap
    // STEP 2: We can then sort first by frequency first and then alphabetically if there is a tie for example
    // Step 3: We return only the first k words

    public List<String> topKFrequent(String[] words, int k) {

        // Count the frequency of each word and store the record and counts in a hashmap
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word: words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // collect the keys into a list in preparation for sorting
        List<String> wordList = new ArrayList<>(freqMap.keySet());

        // now we define our sorting mechanism
        wordList.sort((a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? a.compareTo(b) :
                freqMap.get(b) - freqMap.get(a));

        //        Collections.sort(wordCounts, (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? a.compareTo(b) :
        //                freqMap.get(b) - freqMap.get(a));


        // finally we return a part of the list, giving k
        return wordList.subList(0, k);
    }

    // Time Complexity: O (N log N)
    // The frequency count took O(N) time,
    // sorting took, O (N log N) time

    // Space Complexity: O (N)
    // we stored the frequencies in a HashMap, O (N) worst case
    // we took a part of the sorted list of length O(N)




    // Approach 2: USE MIN-HEAP
    // because this is a top-k elements problem, we can solve this by maintaining a min heap of size k
    // to store the largest k elements so far

    // for every time that we check a new item, we compare it with what we have at the top of the min-heap
    // if it's one of the largest k elements


    // it is similar to the previous idea, but this time we need to check the order,
    // both frequency and alphabetically
    // because the min-heap doesn't automatically guarantee the order that we expect

    public List<String> topKFrequentv2(String[] words, int k) {
        // Count the frequency of each word and store the record and counts in a hashmap
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word: words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // create a heap to solve the top-k problem
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                // define the sorting mechanism for the queue because the min heap doesn't guarantee the order

                (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? b.compareTo(a) :
                        freqMap.get(a) - freqMap.get(a)
        );

        // next we add the words into the min-heap
        for (String word : freqMap.keySet()) {
            // offer will return false if it fails to insert the element on a size restricted queue
            // add will throw illegal state exception
            minHeap.offer(word);

            // the min-heap will sort itself with every addition
            // next we check the size of our min heap to ensure it remains <= k
            if (minHeap.size() > k) {
                // poll fetches and removes the first element of the queue (at the head of the queue)
                // poll returns and removes the min element
                // peek returns min element without removing
                minHeap.poll();
            }
        }


        // Finally, we build our results set
        List<String> results = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            results.add(minHeap.poll());
        }

        // at this point print out the results

        // we need to print out the results in a reverse form
        Collections.reverse(results);

        return results;
    }

    // Time Complexity: O(N log k), where N is the length of input (words)

    // the frequency of each word is counted in O(N) time - the for loop
    // We add N words to the heap, each in O (log k) time.
    // also, we pop from the heap up to k times. this takes O (k log k)

    // We know that k <= N, if we add all of these we get
    // O (N)  + O (N log k) + O (k log k) = O (N log k)



    // Space Complexity: O (N) - used to store our counter
    // We store the heap for O(k) space
}
