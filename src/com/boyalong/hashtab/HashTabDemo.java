package com.boyalong.hashtab;

import java.util.Scanner;

/**
 * @Author: boyalong
 * @Description:    哈希表
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(5);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建HashTab管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;   //显示有多少条链表

    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //分别初始化链表
        for (int i = 0;i <size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工id。得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历链表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id查找员工
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp =  empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){    //找到
            System.out.printf("在第%d条链表中找到雇员 ID = %d\n",empLinkedListNo+1,id);
        }else {
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //编写散列函数，使用一个简单取模法
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList，表示链表
class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        //如果添加第一个雇员
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.name == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no){
        if(head == null){
            System.out.println("第" + (no+1) + "链表为空");
            return;
        }
        System.out.print("第" + (no+1) + "链表信息为：");
        Emp curEmp = head;  //辅助指针
        while(true){
            System.out.printf("id = %d,name = %s\n",curEmp.id,curEmp.name);
            if (curEmp.next == null){   //说明curEmp已到最后节点
                break;
            }
            curEmp = curEmp.next;   //后移，遍历
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){   //找到
                break;
            }
            //退出
            if(curEmp.next == null){    //未找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
