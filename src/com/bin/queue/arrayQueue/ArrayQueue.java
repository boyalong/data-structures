package com.bin.queue.arrayQueue;

/**
 * @Author: boyalong
 * @Date: 2022/05/11/9:22
 * @Description: 使用数组模拟队列
 */
public class ArrayQueue{
    private int maxSize;    //最大数量
    private int front;      //队列头
    private int rear;       //队列尾
    private int[] arr;      //队列数组

    //创建队列构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        front = -1;     //指向队列头，front指向队列头的前一个数据
        rear = -1;      //指向队列尾部，rear指向队列尾的最后一个数据
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //向队列存值
    public void addQueue(int n){
        //判断队列是否为满
        if(isFull()){
            System.out.println("队列已满！！！！");
            return;
        }
        rear ++;
        arr[rear] = n;        //将值n放入队列，队列尾向后移一位
    }

    //向队列取值
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！！");
        }
        front++;
        return arr[front];        //将队列的值从队列头取出，队列头向后移一位
    }

    //显示队列所有数据
    public void showQueue(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空！！！！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列第一个数据
    public int headQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！！");
        }
        return arr[front + 1];
    }
}

