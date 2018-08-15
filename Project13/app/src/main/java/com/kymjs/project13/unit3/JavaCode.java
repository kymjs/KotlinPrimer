package com.kymjs.project13.unit3;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;

public class JavaCode {

    public static void async(Task task) {
        CoroutineUtilsKt.async(task, new Continuation<Unit>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resume(Unit unit) {

            }

            @Override
            public void resumeWithException(Throwable throwable) {

            }
        });
    }

    public static void ui(UI task) {
        CoroutineUtilsKt.ui(task, new Continuation<Unit>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resume(Unit unit) {

            }

            @Override
            public void resumeWithException(Throwable throwable) {

            }
        });
    }

    public static void test() {
        async(new Task() {
            @Override
            public void run() {
                int i = "string".hashCode();
                ui(new UI() {
                    @Override
                    public void run() {
                        //改变 UI
                    }
                });
            }
        });
    }
}
