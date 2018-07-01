package com.kymjs.project3.unit5;

/**
 * Created by ZhangTao on 18/6/13.
 */
public class Main {
    public void exec(TestEnum t) {
        switch (t) {
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            case C:
                System.out.println("C");
                break;
            case D:
                System.out.println("D");
                break;
            default:
        }
    }
}
