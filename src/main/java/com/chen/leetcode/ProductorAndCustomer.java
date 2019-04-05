package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorAndCustomer {

    private final Lock mLock = new ReentrantLock();
    private final Condition mEmpty = mLock.newCondition();
    private final Condition mFull = mLock.newCondition();

    private List<Object> mProduct = new ArrayList();

    public static final int MAX_SIZE = 100;

    public void product(String name) {
        try {
            mLock.lock();
            while (mProduct.size() == MAX_SIZE) {
                try {
                    mFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mProduct.add(new Object());
            mEmpty.signalAll();
        } finally {
            mLock.unlock();
        }
    }

    public void customer() {

        try {
            mLock.lock();
            while (mProduct.size() == 0) {
                try {
                    mEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mProduct.remove(mProduct.size() - 1);
            mFull.signalAll();
        } finally {
            mLock.unlock();
        }
    }
}
