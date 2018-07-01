package com.kymjs.project2.unit1.java;

/**
 * Created by ZhangTao on 18/6/7.
 */
public class Main {

    public static class TimePrinter implements ITimePrinter {
        @Override
        public void printTime() {
            System.out.println(getTime());
        }
    }

    public static void main(String[] args) {

        TimePrinter timePrinter = new TimePrinter();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timePrinter.printTime();
        }
    }
}
