package com.zth.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 猫和少年
 * @create 2022-03-12 17:29
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        subject.add(task1);
        subject.add(task2);

        subject.notifyObserver("hello");
        subject.remove(task1);
        subject.notifyObserver("world");
    }
}


class Subject {
    private final List<Observer> container = new ArrayList<Observer>();

    public void add(Observer observer) {
        container.add(observer);
    }

    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer observer : container) {
            observer.update(object);
        }
    }

}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {
    public void update(Object object) {
        System.out.println("task1 received: " + object);
    }
}

class Task2 implements Observer {
    public void update(Object object) {
        System.out.println("task2 received: " + object);
    }
}

