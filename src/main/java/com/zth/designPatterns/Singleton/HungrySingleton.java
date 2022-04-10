package com.zth.designPatterns.Singleton;

/**
 * @author 猫和少年
 * @create 2022-04-09 14:37
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
