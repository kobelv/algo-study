package com.kobe.queue;

/**
 * 循环队列 - 通过数组实现
 *
 * 起点：head==tail==0
 * 队列为空：head==tail
 * 队列满了：(tail+1)%size=head，就像跑步比赛里的套圈一样
 *
 * 待完善功能：扩容、线程安全（生产者消费者模型）
 */
public class CircleQueueByArray {
    public int capacity;
    public String[] items;
    public int head;
    public int tail;

    public CircleQueueByArray(){
        head = 0;
        tail = 0;
        items = new String[5];
        capacity = 5;
    }

    public int enqueue(String item){
        if((tail+1)%capacity == head){
            //queue is full
            System.out.println("queue is full");
            return -1;
        }

        if (tail >= capacity){
            tail = 0;
        }
        items[tail]=item;
        tail++;

        return tail-1;
    }

    public String dequeue(){
        if (head == tail){
            //queue is empty
            System.out.println("queue is empty");
            return null;
        }

        String result = items[head];
        items[head] = null;
        head ++;
        if (head >= capacity){
            head = 0;
        }

        return result;
    }

    public void printQueue(){
        System.out.println("start to print:");
        for (int i=0; i<items.length; i++){
            System.out.println(items[i]+"--");
        }
    }

    public static void main(String[] args) {
        CircleQueueByArray queue = new CircleQueueByArray();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

        queue.enqueue("g");
        queue.enqueue("h");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("i");
        queue.enqueue("x");
        queue.enqueue("y");

        queue.printQueue();

    }

}
