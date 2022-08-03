package com.myapp.tracnghiemtienganh;

public class FunctionCommon {
    public static int getRandom(int max, int min) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
