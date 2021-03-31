package practice.stackAndQueue;

import java.util.*;

public class _23LruCache {
    
    private static LinkedHashMap<Integer, Integer> map;
    private static int CAPACITY;

    _23LruCache(int capacity)
    {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };
    }

    // This method works in O(1)
    public static int get(int key)
    {
        return map.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        map.put(key, value);
    }
}
