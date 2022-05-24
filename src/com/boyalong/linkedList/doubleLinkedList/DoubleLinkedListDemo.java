package com.boyalong.linkedList.doubleLinkedList;

/**
 * @Author: boyalong
 * @Date: 2022/05/16/20:03
 * @Description: 双向链表的测试
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建单向链表
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add(hero1);
        doubleLinkList.add(hero2);
        doubleLinkList.add(hero3);
        doubleLinkList.add(hero4);
        //遍历
        doubleLinkList.list();

        //修改
        System.out.println("修改后的链表：");
        HeroNode newHeroNode = new HeroNode(4,"张顺","浪里白条");
        doubleLinkList.update(newHeroNode);
        doubleLinkList.list();

        //删
        System.out.println("删除后链表的情况");
        doubleLinkList.del(3);
        doubleLinkList.list();

        //按编号加
        System.out.println("按编号加后的链表：");
        HeroNode heroX = new HeroNode(3, "花和尚", "鲁智深");
        doubleLinkList.addByOrder(heroX);
        doubleLinkList.list();
    }
}
