package com.example.ndk;

public class HelloJni {
    static {
        //加载.so类库，加载的名称去掉lib
        System.loadLibrary("hello");
    }
    public native int sayHello(int a);
}
