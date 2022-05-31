package com.boyalong.linkedList.singleLinkedList;

/**
 * @Author: boyalong
 * @Description: 定义 SingleLinkedList  管理元素
 */
public class SingleLinkedList {
    //初始化一个Head头节点，内容为空不能动
    private HeroNode head = new HeroNode(0, "", "");

    //返头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单项链表
    //1.当找到这个链表的最后节点时
    //2.将这个节点的next指向新的节点

    /**
     * 直接插入到单链表尾
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
            temp.next = heroNode;       //将heroNode的属性覆盖temp.next
        }
    }

    /**
     * 遍历链表
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
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
             temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d不存在",no);
        }
    }

    /**
     * 查询单链表有效节点个数
     * @param head
     * @return
     */
    public static int getLength(HeroNode head)  {
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查询倒数第index的节点
     * @param head
     * @param index
     * @return
     */
    public static HeroNode  findLastIndexNode(HeroNode head, int index){
        //如果判断链表为空，返回为null
        if(head.next == null){
            return null;
        }
        //返回链表长度
        int size = getLength(head);
        //第二次遍历倒数的第K个节点，size - index
        if(index <= 0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


}

