package com.boyalong.queue.arrayQueue;

import java.util.Scanner;

/**
 * @Author: boyalong
 * @Date: 2022/05/11/9:46
 * @Description: 普通队列测试
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';             // 用于用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从数列取出数据");
            System.out.println("h(head): 查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case's':
                    queue.showQueue();
                    break;
                case'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case'g':
                    try{
                        int res  = queue.getQueue();
                        System.out.printf("取出的数据为：%d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列头部值为：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
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
