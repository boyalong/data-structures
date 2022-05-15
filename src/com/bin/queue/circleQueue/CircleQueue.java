package com.bin.queue.circleQueue;

/**
 * @Author: boyalong
 * @Date: 2022/05/11/9:22
 * @Description: 使用数组模拟队列
 */
public class CircleQueue {
    private int maxSize;    //最大容量
    private int front;      //队列头
    private int rear;       //队列尾
    private int[] arr;      //队列数组

    //创建队列构造器
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = 0;      //front指向队列第一个元素，arr[front]就是队列第一个元素
        rear = 0;      //rear指向队列最后一个元素的后一个位置，空出一个位置为约定
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //向队列存值
    public void addQueue(int n) {
        //判断队列是否为满
        if (isFull()) {
            System.out.println("队列已满！！！！");
            return;
        }
        arr[rear] = n;      //直接将数据加入
        rear = (rear + 1) % maxSize;       //将rear往后移一个单位
    }

    //向队列取值
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！！！");
        }
        int value = arr[front];     //先将第一个元素存入一个临时变量value
        front = (front + 1) % maxSize;      //将front往后移一个单位
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空！！！！");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize, arr[i % maxSize]);
        }
    }

    //求当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列第一个数据
    public int headQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！！！");
        }
        return arr[front];
    }
}

