package b.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    // Least Recently Used
    // An LRU cache is designed to discard the least recently used items first
    // This algorithm requires keeping track of what was used and when,
    // which can be expensive if one wants to make sure the algorithm always discards the least recently used item

    // The idea of this problem is to perform the following operations in O(1) constant time
    // 1. Get the key / Check if the key exists
    // 2. Put the key
    // 3. Delete the first key added

    // APPROACH: We use an Ordered Dictionary approach. It uses the Java LinkedHashMap.
    // Combines the functionalities of a HashTable and a LinkedList
    // it maintains a doubly linked list
    // iteration order by default is the order in which the keys are inserted into the map,
    // but we change this to access order if we want to use it for an LRU cache

    // To get or put the key, We can do this in O(1) time
    // The last operation is done by the linkedList in O(1) time

    // we extend the LinkedHashMap class

    private int capacity;

    // we create the constructor
    public LRUCache(int capacity) {
        // set initial capacity, load factor and access order

        // capacity is the number of buckets in the hashmap

        // default load factor is 0.75F i.e. 75% of the capacity
        // load factor is the total number of entries divided by the number of bins.
        // That's the average number of entries stored in each bin of the HashMap.
        // This number should be kept small in order for the HashMap to have expected constant
        // running time for the get(key) and put(key,value) methods.
        // keys = entries, list = bins

        // accessOrder is set to true for access-order, false for insertion-order
        // we need access order for LRU cache

        // because of this, it will always have recently used item as first item in the map
        // removeEldestEntry will remove the least recently used item and not the one who was put at earliest
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    // get implementation
    public int get(int key) {
        // return -1 if not found
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    //    for (Map.Entry<String, String> entry : map.entrySet()) {
    //        System.out.println(entry.getKey() + "/" + entry.getValue());
    //    }


    // next we override the removeEldestEntry method
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        // LinkedHashMap implementation below
        // return super.removeEldestEntry(eldest);


        // we can make this return false if the size is greater than capacity
        return size() > capacity;
    }

    // Time Complexity: O(1) for both put and get. We are using the LinkedHashMap for this,
    // and it does it in constant time

    // Space Complexity: O(N), where N is capacity. This space is used in the LinkedHashMap
    // we can expect at most capacity + 1 elements

}

class testLRUCache {

    public static void main(String[] args) {

        //  don't use this exact example
        //  ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //  [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        cache.get(1);    // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        cache.get(2);    // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        cache.get(1);    // return -1 (not found)
        cache.get(3);    // return 3
        cache.get(4);    // return 4

        System.out.println(cache.get(2));
    }
}
