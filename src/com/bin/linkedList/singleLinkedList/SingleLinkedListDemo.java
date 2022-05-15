package com.bin.linkedList.singleLinkedList;

/**
 * @Author: boyalong
 * @Date: 2022/05/12/23:02
 * @Description: 单链链表测试
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);

        //修改节点代码
        HeroNode newHeroNode = new HeroNode(2,"卢老板","麒麟哥哥");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.del(1);
        // 测试一下单链表的反转功能
        singleLinkedList.list();
    }
}
