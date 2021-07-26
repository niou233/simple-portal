package com.niou.designpatterns.iterator.v1;

import java.util.Random;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/25 19:38<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/25 	niou		    		新建
 * </pre>
 *
 */
public class Main {

    public static void main(String[] args) {
        Collection_ link = new LinkList_();
        Collection_ array = new ArrayList_();
        Random random = new Random();
        for(int i=0; i < 5; i++){
            int t = random.nextInt(100);
            link.add(t);
            array.add(t);
        }
        Iterator_ iterator = link.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class ArrayList_ implements Collection_{
    Object[] arr = new Object[10];
    int size = 0;
    @Override
    public void add(Object o) {
        if(size >= arr.length){
            Object[] arr1 = new Object[size*2];
            System.arraycopy(arr, 0, arr1, 0, size);
            arr = arr1;
        }
        arr[size] = o;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }
    class ArrayListIterator implements  Iterator_ {
        int index;
        public ArrayListIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            if(index < size){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(index < size){
                index++;
                return arr[index - 1];
            }
            return null;
        }
    }
}
class LinkList_ implements Collection_{
    Node head = null;
    Node tail = null;
    int size = 0;
    @Override
    public void add(Object o) {
        Node n = new Node();
        n.o = o;
        if(head == null){
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkListIterator();
    }

    class Node {
        Object o;
        Node next;
    }
    class LinkListIterator implements Iterator_ {
        Node currentNode = null;

        public LinkListIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            if(currentNode != null && currentNode.o != null){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(currentNode != null && currentNode.o != null){
                Object o = currentNode.o;
                currentNode = currentNode.next;
                return o;
            }
            return null;
        }
    }
}

interface Collection_ {
    void add(Object o);
    int size();
    Iterator_ iterator();
}

interface Iterator_ {
    boolean hasNext();
    Object next();
}