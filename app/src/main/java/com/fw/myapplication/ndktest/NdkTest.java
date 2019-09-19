package com.fw.myapplication.ndktest;

public class NdkTest {
    public static native String stringFromUTF(String str);

    static {
        System.loadLibrary("yemu");
    }
}
