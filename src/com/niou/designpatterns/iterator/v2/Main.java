package com.niou.designpatterns.iterator.v2;

import java.util.Random;

/**
 * <pre>
 * @ClassName Main.java
 * 泛型
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
        Collection_<Integer> link = new LinkList_<>();
        Collection_<Integer> array = new ArrayList_<>();
        Random random = new Random();
        for(int i=0; i < 5; i++){
            int t = random.nextInt(100);
            link.add(t);
            array.add(t);
        }
        Iterator_<Integer> iterator = link.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class ArrayList_<T> implements Collection_<T> {
    Object[] arr =  new Object[10];
    int size = 0;
    @Override
    public void add(T o) {
        if(size >= arr.length){
            T[] arr1 = (T[]) new Object[size*2];
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
    public Iterator_<T> iterator() {
        return new ArrayListIterator();
    }
    class ArrayListIterator<T> implements Iterator_<T> {
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
        public T next() {
            if(index < size){
                index++;
                return (T) arr[index - 1];
            }
            return null;
        }
    }
}

class LinkList_<T> implements Collection_<T> {
    Node head = null;
    Node tail = null;
    int size = 0;
    @Override
    public void add(T o) {
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
    public Iterator_<T> iterator() {
        return new LinkListIterator();
    }

    class Node<T> {
        T o;
        Node next;

        public T getO() {
            return o;
        }

        public void setO(T o) {
            this.o = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    class LinkListIterator<T> implements Iterator_<T> {
        Node<T> currentNode = null;

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
        public T next() {
            if(currentNode != null && currentNode.o != null){
                T o = currentNode.getO();
                currentNode = currentNode.next;
                return o;
            }
            return null;
        }
    }
}

interface Collection_<T> {
    void add(T o);
    int size();
    Iterator_<T> iterator();
}

interface Iterator_<T> {
    boolean hasNext();
    T next();
}