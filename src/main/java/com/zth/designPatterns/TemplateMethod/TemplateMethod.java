package com.zth.designPatterns.TemplateMethod;

/**
 * @author 猫和少年
 * @create 2021-12-17 21:35
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass abstractClass = new SubClass();
        abstractClass.option();

        abstractClass = new SubClass2();
        abstractClass.option();
    }
}


abstract class AbstractClass{
    public void option(){
        // 准备工作
        System.out.println("pre .......");
        templateMethod();
        // 结尾工作
        System.out.println("teardown.....");
    }

    abstract void templateMethod();
}


class  SubClass extends AbstractClass{

    @Override
    void templateMethod() {
        System.out.println("subclass  executed...");
    }
}

class  SubClass2 extends AbstractClass{

    @Override
    void templateMethod() {
        System.out.println("subclass2  executed...");
    }
}