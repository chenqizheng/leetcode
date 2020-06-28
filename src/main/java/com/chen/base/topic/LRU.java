package com.chen.base.topic;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {

    private LinkedList<String> linkedList = new LinkedList<>();
    private HashMap<String, String> map = new HashMap<String, String>();
    private int cap;

    public LRU(int cap) {
        this.cap = cap;
    }

    public String get(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        String value = map.get(key);
        put(key, value);
        return value;
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            linkedList.remove(value);
            map.remove(key);
        }
        if (cap <= linkedList.size()) {
            linkedList.removeLast();
            map.remove(key);
        }
        map.put(key, value);
        linkedList.addFirst(value);
    }
}
