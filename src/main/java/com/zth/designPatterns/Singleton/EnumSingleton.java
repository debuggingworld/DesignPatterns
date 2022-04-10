package com.zth.designPatterns.Singleton;

/**
 * @author 猫和少年
 * @create 2022-04-09 17:33
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }
}
