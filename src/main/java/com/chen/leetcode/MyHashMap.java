package com.chen.leetcode;

/***
 * leetcode: https://leetcode.com/problems/design-hashmap/
 */
public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.get(1);
        hashMap.get(3);
    }

    private Entry[] bucket;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        bucket = new Entry[1000];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new Entry(-1, -1);
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Entry preEntry = findPreNode(bucket[getIndex(key)], key);
        Entry entry = new Entry(key, value);
        if (preEntry.next != null) {
            entry.next = preEntry.next.next;
            preEntry.next = entry;
        } else {
            preEntry.next = entry;
        }

    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % 1000;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Entry preEntry = findPreNode(bucket[getIndex(key)], key);
        if(preEntry.next == null) {
            return -1;
        }
        return preEntry.next.value;
    }

    public Entry findPreNode(Entry entry, int key) {
        Entry pre = null;
        while (entry != null) {
            if (key == entry.key) {
                break;
            }
            pre = entry;
            entry = entry.next;
        }
        return pre;
    }


    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Entry preEntry = findPreNode(bucket[getIndex(key)], key);
        if (preEntry != null) {
            if (preEntry.next != null) {
                Entry next = preEntry.next.next;
                preEntry.next = next;
            }
        }
    }


    class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
