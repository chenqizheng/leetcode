package com.chen.patterns;

public class SingleInstance {
    private static volatile SingleInstance mInstance = null;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (mInstance == null) {
            synchronized (SingleInstance.class) {
                if (mInstance == null) {
                    mInstance = new SingleInstance();
                }
            }
        }
        return mInstance;
    }

}
