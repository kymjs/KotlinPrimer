package com.kymjs.project13.unit1;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public class JavaCode {

    public void test() {
        Test.sayMessage("");

        KotlinCode.doFunction(new Function1<Integer, Unit>() {
            @Override
            public Unit invoke(Integer integer) {
                return null;
            }
        });
    }
}
