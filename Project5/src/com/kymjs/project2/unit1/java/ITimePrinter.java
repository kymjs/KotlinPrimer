package com.kymjs.project2.unit1.java;

/**
 * Created by ZhangTao on 18/6/7.
 */
public interface ITimePrinter {
    default long getTime() {
        return System.currentTimeMillis();
    }

    void printTime();
}
