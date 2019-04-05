package com.chen.leetcode;

import java.util.concurrent.LinkedBlockingQueue;

public class ProductorAndCustomer2 {

    private LinkedBlockingQueue<Object> mObjects;
    public static final int MAX_SIZE = 100;

    public void product(String name) {
        if(mObjects.size() == MAX_SIZE) {

        }
        try {
            mObjects.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void customer() {
        try {
            mObjects.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
