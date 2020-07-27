package com.letcode.循环队列20200329;

import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {

    private List<Integer> data;
    private int head;
    private int tail;
    private int size ;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data=new ArrayList<Integer>(k);
        head=-1;
        tail=-1;
        size=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(tail==size-1){
            data.set(0,value);
        }else if(tail<head){
            data.set(tail,value);
        }else {
            data.add(value);
        }
        if(tail==size-1){
            tail=0;
        }else{
            tail++;
        }
        if(head==-1){
            head=0;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head<size-1){
            head++;
        }else{
            head=1;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(head==-1){
            return -1;
        }
        return data.get(head-1);
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(head==-1){
            return -1;
        }
        return data.get(tail);
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head==-1&&tail==-1){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail+1)%size==head;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());

    }

}