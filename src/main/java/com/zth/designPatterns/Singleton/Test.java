package com.zth.designPatterns.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 猫和少年
 * @create 2022-04-09 14:43
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class Test {
    public static void main(String[] args) throws Exception {

        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("testObject"));
        outputStream.writeObject(instance);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("testObject"));
        InnerClassSingleton serializedObject = ((InnerClassSingleton) inputStream.readObject());
        inputStream.close();

        /**
         * 添加 readResolve() 前 false
         * 添加后为 true
         */
        System.out.println(serializedObject == instance);
    }
}
