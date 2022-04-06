package com.zth.designPatterns.abstractfactory;

/**
 * @author 猫和少年
 * @create 2022-04-05 16:45
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IFactory dellFactory = new DellFactory();
        IFactory HPFactory = new HPFactory();
        Keyboard dellKeyboard = dellFactory.createKeyboard();
        Monitor monitor = HPFactory.createMonitor();
    }
}


interface Keyboard {
    void print();
}

class DellKeyboard implements Keyboard {
    @Override
    public void print() {
        //...dell...dell;
    }
}

class HPKeyboard implements Keyboard {
    @Override
    public void print() {
        //...HP...HP;
    }
}

interface Monitor {
    void play();
}

class DellMonitor implements Monitor {
    @Override
    public void play() {
        //...dell...dell;
    }
}

class HPMonitor implements Monitor {
    @Override
    public void play() {
        //...HP...HP;
    }
}

interface MainFrame {
    void run();
}

class DellMainFrame implements MainFrame {
    @Override
    public void run() {
        //...dell...dell;
    }
}

class HPMainFrame implements MainFrame {
    @Override
    public void run() {
        //...HP...HP;
    }
}

/**
 * 工厂类
 */
interface IFactory {
    MainFrame createMainFrame();

    Monitor createMonitor();

    Keyboard createKeyboard();
}

class DellFactory implements IFactory {
    @Override
    public MainFrame createMainFrame() {
        MainFrame mainFrame = new DellMainFrame();
        //...造一个Dell主机;
        return mainFrame;
    }

    @Override
    public Monitor createMonitor() {
        Monitor monitor = new DellMonitor();
        //...造一个Dell显示器;
        return monitor;
    }

    @Override
    public Keyboard createKeyboard() {
        Keyboard keyboard = new DellKeyboard();
        //...造一个Dell键盘;
        return keyboard;
    }
}

class HPFactory implements IFactory {
    @Override
    public MainFrame createMainFrame() {
        MainFrame mainFrame = new HPMainFrame();
        //...造一个HP主机;
        return mainFrame;
    }

    @Override
    public Monitor createMonitor() {
        Monitor monitor = new HPMonitor();
        //...造一个HP显示器;
        return monitor;
    }

    @Override
    public Keyboard createKeyboard() {
        Keyboard keyboard = new HPKeyboard();
        //...造一个HP键盘;
        return keyboard;
    }
}