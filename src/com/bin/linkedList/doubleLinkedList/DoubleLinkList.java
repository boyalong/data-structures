package com.bin.linkedList.doubleLinkedList;


/**
 * @Author: boyalong
 * @Date: 2022/05/16/17:20
 * @Description:
 */
public class DoubleLinkList {
    //初始化一个Head头节点，内容为空不能动
    private HeroNode head = new HeroNode(0, "", "");

    //返头节点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 遍历双向链表，同单向链表一样
     */
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能为空，定义一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否在最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将节点后移动一位,输出下一个元素信息
            temp = temp.next;
        }
    }

    /**
     * 添加一个节点到链表尾
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //头节点不能动，需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果未找到最后，将temp后移
            temp = temp.next;
        }
        //将最后的节点的next指向新节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 按照编号进行插入排序
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //头节点不能动，需要一个辅助遍历temp
        HeroNode temp = head;
        boolean flag = false;
        //遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {        //说明temp已经在链表最后
                break;
            } else if (temp.next.no == heroNode.no) {       //说明希望添加的heroNode的编号已经存在
                flag = true;
                break;
            } else if (temp.next.no > heroNode.no) {        //位置找到，在temp的后面插入
                break;
            }
            temp = temp.next;       //后移，遍历当前链表
        }

        if (flag) {
            //说明编号已经存在
            System.out.printf("插入的英雄编号 %d 已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中,在temp后面
            heroNode.next = temp.next;      //将原先的temp.next赋给heroNode.next
            heroNode.pre = temp.pre;
            temp.next = heroNode;       //将heroNode的属性覆盖temp.next
        }
    }

    /**
     * 改
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nikeName = newHeroNode.nikeName;
        }else {
            System.out.printf("没有找到编号为%d,不能修改\n",newHeroNode.no);
        }
    }

    /**
     * 删
     * @param no
     */
    public void del(int no){

        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("当前链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if(temp.next != null){      //最后一个节点不需要执这步
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的节点%d不存在",no);
        }
    }
}
