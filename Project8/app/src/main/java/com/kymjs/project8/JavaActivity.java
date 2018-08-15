package com.kymjs.project8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlinx.coroutines.experimental.android.HandlerContextKt;

/**
 * Created by ZhangTao on 18/7/9.
 */
public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LaunchCoroutineKt.getHtml(new Continuation<String>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return HandlerContextKt.getUI();
            }

            @Override
            public void resume(String s) {
                Log.d("kymjs", "协程执行成功" + s);
            }

            @Override
            public void resumeWithException(Throwable throwable) {

            }
        });
    }
}
