package com.kobe.queue;

/**
 * 双端循环队列，
 * 1. 可以从头部插入也可以从尾部插入
 * 2. 可以从头部删除也可以从尾部删除
 * @param <T>
 */
public class MyCircleDeque<T> {
    Node<T> head;
    Node<T> tail;
    private int size;
    private int capacity;

    public MyCircleDeque(int k){
        head = null;
        tail = null;
        capacity = k;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean enqueueFront(T value){
        return enqueueInternal(value, true);
    }

    public boolean enqueueLast(T value){
        return enqueueInternal(value, false);
    }

    public boolean dequeueFront(){
        if (isEmpty()){
            return false;
        }
        head.prev.next = head.next;
        head.next.prev = head.prev;
        head = head.next;
        size--;

        return true;
    }

    public boolean dequeueLast(){
        if (isEmpty()){
            return false;
        }
        tail.prev.next = tail.next;
        tail.next.prev = tail.prev;
        tail = tail.prev;
        size--;

        return true;
    }

    public T getFront(){
        if (isEmpty()){
            return null;
        }
        return head.value;
    }

    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return tail.value;
    }

    private boolean enqueueInternal(T value, boolean resetHead){
        if (isFull()){
            return false;
        }

        Node<T> node = new Node<>(value);
        if(head == null){
            head = node;
            tail = node;
            size ++;
            return true;
        }

        head.prev = node;
        node.prev = tail;
        node.next = head;
        tail.next = node;
        size ++;

        if (resetHead){
            head = node;
        } else {
            tail = node;
        }
        return true;
    }

    class Node<T>{
        T value;
        Node prev;
        Node next;

        public Node(T item){
            value = item;
            prev = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        MyCircleDeque circularDeque = new MyCircleDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.enqueueLast(1));		        // 返回 true
        System.out.println(circularDeque.enqueueLast(2));				        // 返回 true
        System.out.println(circularDeque.enqueueFront(3));				        // 返回 true
        System.out.println(circularDeque.enqueueFront(4));				        // 已经满了，返回 false
        System.out.println(circularDeque.getLast());	  				// 返回 2
        System.out.println(circularDeque.isFull());					        // 返回 true
        System.out.println(circularDeque.dequeueLast());			        // 返回 true
        System.out.println(circularDeque.enqueueFront(4));				        // 返回 true
        System.out.println(circularDeque.getFront());					// 返回 4

    }

}
