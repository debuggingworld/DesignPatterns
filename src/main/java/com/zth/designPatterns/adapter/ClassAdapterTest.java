package com.zth.designPatterns.adapter;

/**
 * @author 猫和少年
 * @create 2022-03-13 17:08
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new Adapter2();
        target.output5V();
    }
}

/**
 * class Adapter
 */
class Adapter2 extends Adaptee implements Target{
    @Override
    public int output5V() {
        int v = output220V();
        System.out.printf("原始电压： %d v ‐ > 输出电压： %d v ",v,5 );
        return 0;
    }
}
