package com.chen;

import java.util.List;

public class Utils {

    public static <T> void print(List<List<T>> result) {
        for (List<T> list : result) {
            for (T i : list) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
