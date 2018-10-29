package com.chen.nowcoder;

public class RotationString {
    public static boolean checkRotation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return (str1 + str1).indexOf(str1) != -1;
    }


    public static void main(String[] args) {
         System.out.print(checkRotation("abc","cab"));
    }
}
