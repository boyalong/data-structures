package com.boyalong.stack;

import java.util.Scanner;

/**
 * @Author: boyalong
 * @Date: 2022/05/18/10:15
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = null;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("出栈数据为%d\n",res);
                    }   catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack{
    private int maxSize;        //栈的大小
    private int[] stack;        //数组模拟栈
    private int top = -1;       //栈顶

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack =  new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据~~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据~~");
            return;
        }
        for (int i = top;i >= 0;i--){
            System.out.printf("stack[%d]\n",stack[i]);
        }
    }

}
