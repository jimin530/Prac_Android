package com.jmdroid.prac_crawling;


import android.content.Context;

import java.util.ArrayList;

public class Single_Value {
    private static Single_Value ourInstance = new Single_Value();

    public static Single_Value getInstance() {
        return ourInstance;
    }

    private Single_Value() {
    }

    Context context;
    public ArrayList<String> imageData = new ArrayList<>();
}