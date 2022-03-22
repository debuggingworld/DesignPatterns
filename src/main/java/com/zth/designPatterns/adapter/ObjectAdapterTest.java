package com.zth.designPatterns.adapter;

/**
 * @author 猫和少年
 * @create 2022-03-13 16:55
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.output5V();
    }
}

class Adaptee{
    public int output220V(){
        return 220;
    }
}

interface Target {
    int output5V();
}

/**
 * Object Adapter
 */
class Adapter implements Target{

    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5V() {
        int v = adaptee.output220V();
        System.out.printf("原始电压： %d v ‐ > 输出电压： %d v ",v,5 );
        return 5;
    }
}
