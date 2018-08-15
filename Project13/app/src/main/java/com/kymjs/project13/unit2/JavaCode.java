package com.kymjs.project13.unit2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaCode {

    IActivityManager activityManager = new IActivityManager() {
        @Override
        public void bindService() {
            System.out.println("============bindService");
        }

        @Override
        public void unbindService() {
            System.out.println("============unbindService");
        }
    };

//    class IActivityManagerHook implements InvocationHandler {
//        IActivityManager activityManager;
//
//        public IActivityManagerHook(IActivityManager activityManager) {
//            this.activityManager = activityManager;
//        }
//
//        @Override
//        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//            if ("bindService".equals(method.getName())) {
//                activityManager.bindService();
//            } else if ("unbindService".equals(method.getName())) {
//                activityManager.unbindService();
//            }
//            return null;
//        }
//    }

    void test() throws Exception {
//        Object proxy = Proxy.newProxyInstance(
//                Thread.currentThread().getContextClassLoader(),
//                new Class<?>[]{Class.forName("android.app.IActivityManager")},
//                new IActivityManagerHook(activityManager));

        ActivityManagerHook hook = new ActivityManagerHook(activityManager);
    }

}
