package com.niou.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/14 23:14<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/14 	niou		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        BrachNode root = new BrachNode("root");
        BrachNode chapter1 = new BrachNode("chapter1");
        BrachNode chapter2 = new BrachNode("chapter2");
        BrachNode chapter3 = new BrachNode("chapter3");
        Node c11 = new LeafNode("c11");
        Node c22 = new LeafNode("c22");
        root.addNode(chapter1);
        root.addNode(chapter2);
        chapter1.addNode(chapter3);
        chapter2.addNode(c11);
        chapter3.addNode(c22);
        tree(root, 0);
    }
    static void tree(Node n,int depth) {
        for (int i = 0; i < depth; i++){
            System.out.print("--");
        }
        n.pringtName();
        if(n instanceof BrachNode){
            for (Node t : ((BrachNode)n).list){
                tree(t, depth + 1);
            }
        }
    }
}

abstract class Node {
    public abstract void pringtName();
}

class LeafNode extends Node {
    String name;

    public LeafNode(String name) {
        this.name = name;
    }

    @Override
    public void pringtName() {
        System.out.println(this.name);
    }
}

class BrachNode extends Node {
    String name;
    List<Node> list = new ArrayList<Node>();

    public BrachNode(String name) {
        this.name = name;
    }

    public void addNode(Node n){
        list.add(n);
    }
    @Override
    public void pringtName() {
        System.out.println(this.name);
    }
}
