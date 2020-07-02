package com.chen.concurrent;

import com.chen.leetcode.PowXN;

import java.util.Random;

public class BooleanLockTest {

    private volatile Boolean isOn = false;
    private Object lock = new Object();


    public void testWait() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (isOn) {
                    while (isOn) {
                        try {
                            System.out.println("test isOn wait");
                            isOn.wait();
                        } catch (InterruptedException e) {
                            continue;
                        }
                    }
                }
                System.out.println("test isOn = false");
            }
        }).start();
    }

    public void testNotify(){
        isOn =true;

        // mock Time-consuming operation
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(new Random().nextInt(10), new Random().nextInt(5)));

        isOn = false;
        synchronized (isOn) {
            isOn.notifyAll();
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<1000;i++){
            BooleanLockTest test = new BooleanLockTest();
            test.testWait();
            test.testNotify();
        }
    }
}
