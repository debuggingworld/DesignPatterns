package com.zth.designPatterns.factory;

/**
 * @author 猫和少年
 * @create 2022-03-30 22:00
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class FactoryMethod {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteProductA();
        Product product = factory.createProduct();
        product.method();
    }

}

interface Product {
    void method();
}

class ProductA implements Product {
    @Override
    public void method() {
        System.out.println("ProductA.method executed. ");
    }
}

class ProductB implements Product {
    @Override
    public void method() {
        System.out.println("ProductB.method executed. ");
    }
}

abstract class AbstractFactory {
    abstract Product createProduct();
    Product getObject() {
        Product product = createProduct();
        // ...
        // ...
        return product;
    }
}

class ConcreteProductA extends AbstractFactory {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreteProductB extends AbstractFactory {
    @Override
    Product createProduct() {
        return new ProductB();
    }
}