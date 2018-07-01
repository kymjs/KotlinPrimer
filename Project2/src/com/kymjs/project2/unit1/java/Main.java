package com.kymjs.project2.unit1.java;

import java.io.File;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

/**
 * Created by ZhangTao on 18/6/7.
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("Project2.iml");
        
        String content = FilesKt.readText(file, Charsets.UTF_8);
        System.out.println(content);
    }
}
