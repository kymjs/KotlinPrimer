package com.kymjs.kotlinprimer.unit2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by ZhangTao on 18/7/1.
 */
public class JavaRx {
    public static void main(String[] args) {
        final String[] a = new String[]{"4", "0", "7", "i", "f", "w", "0", "9"};
        final Integer[] index = new Integer[]{5, 3, 9, 4, 8, 3, 1, 9, 2, 1, 7};

        Observable.just(index)
                .flatMap(new Function<Integer[], ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer[] integers) throws Exception {
                        return Observable.fromArray(integers);
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) throws Exception {
                        return i < a.length;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return a[integer];
                    }
                })
                .reduce(new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        return s + s2;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("密码是：" + s);
                    }
                });
    }
}
