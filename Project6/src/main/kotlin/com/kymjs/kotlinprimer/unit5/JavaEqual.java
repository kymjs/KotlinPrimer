package com.kymjs.kotlinprimer.unit5;

public class JavaEqual {

    public static void main(String[] s) {
        String string = "string";
        String newString = new String("string");
        System.out.println(string == newString);
        System.out.println(string.equals(newString));
    }
}
