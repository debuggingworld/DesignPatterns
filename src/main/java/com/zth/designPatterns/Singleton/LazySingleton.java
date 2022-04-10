package com.zth.designPatterns.Singleton;

/**
 * @author 猫和少年
 * @create 2022-04-09 14:28
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class LazySingleton {
    private volatile static LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (null == instance){
            synchronized (LazySingleton.class){
                if (null == instance){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
