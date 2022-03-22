package com.zth.designPatterns.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 猫和少年
 * @create 2022-03-21 21:10
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class FlyweightTest {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("xxx"));
        TreeNode treeNode2 = new TreeNode(5, 4, TreeFactory.getTree("xxx"));
        TreeNode treeNode3 = new TreeNode(13, 24, TreeFactory.getTree("yyy"));
        TreeNode treeNode4 = new TreeNode(15, 24, TreeFactory.getTree("yyy"));
    }
}


class Tree {
    String name;
    public Tree(String name) {
        System.out.println("name: "+name +" tree created. ");
        this.name = name;
    }
}

class TreeNode {
    int x;
    int y;
    Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory {
    private static final Map<String, Tree> cache = new ConcurrentHashMap<>();

    protected static Tree getTree(String name) {
        if (cache.containsKey(name)) {
            return cache.get(name);
        } else {
            Tree tree = new Tree(name);
            cache.put(name, tree);
            return tree;
        }
    }
}