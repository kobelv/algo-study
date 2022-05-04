package com.kobe.algo;

import com.kobe.linkedlist.ListNode_Double;

import java.util.*;

public class LeetCode146_LRUCache {
    public Map<Integer, ListNode_Double> map = new HashMap<>();
    public int size;
    public int capacity;
    public ListNode_Double list;
    public ListNode_Double dummyHead;
    public ListNode_Double dummyTail;

    public LeetCode146_LRUCache(int capacity){
        list = new ListNode_Double();
        dummyHead = new ListNode_Double();
        dummyTail = new ListNode_Double();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }

        ListNode_Double node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;

        ListNode_Double tmp =  dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = tmp;
        tmp.pre = node;

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0){
            //删除双链表尾部
            dummyTail.pre.next = null;
            dummyTail = dummyTail.pre;
            capacity ++;
        }

        ListNode_Double node = null;
        if (map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            map.put(key, node);

       } else{
            node = new ListNode_Double(value);
            map.put(key, node);
            capacity --;
       }

        //插到双链表的头部
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next.pre = node;

    }

    public static void main(String[] args) {
        LeetCode146_LRUCache lRUCache = new LeetCode146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }



}
