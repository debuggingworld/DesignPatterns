package com.zth.designPatterns.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:25
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */

public class ComparatorTest {

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person(10,111),new Person(18,99),new Person(15,122)};

        System.out.println(Arrays.toString(people));
        Arrays.sort(people,new SortByAge());
        System.out.println(Arrays.toString(people));
        Arrays.sort(people,new SortByHeight());
        System.out.println(Arrays.toString(people));

        /**
         *  [Person{age=10, height=111}, Person{age=18, height=99}, Person{age=15, height=122}]
         [Person{age=10, height=111}, Person{age=15, height=122}, Person{age=18, height=99}]
         [Person{age=15, height=122}, Person{age=10, height=111}, Person{age=18, height=99}]
         */
    }

}

class SortByHeight implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return  o1.getHeight()-o2.getHeight();
    }
}

class SortByAge implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}

class Person{
    int age;
    int height;

    public Person(int age, int height) {
        this.age = age;
        this.height = height;
    }

    /* getter setter  toString */

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}