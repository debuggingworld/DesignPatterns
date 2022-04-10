package com.zth.designPatterns.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author 猫和少年
 * @create 2022-04-09 14:40
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class InnerClassSingleton implements Serializable {
    static final long serialVersionUID = 42L;

    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        if (null != InnerClassHolder.instance){
            throw new RuntimeException(" 单例不允许多个实例 ");
        }
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }

    Object readResolve() throws ObjectStreamException {
        return InnerClassSingleton.getInstance();
    }
}


