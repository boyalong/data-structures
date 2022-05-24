package com.boyalong.linkedList.singleLinkedList;

/**
 * @Author: boyalong
 * @Date: 2022/05/12/22:37
 * @Description:
 */
public class HeroNode {
    //定义HeroNode，每个HeroNode对象就是一个节点
        public int no;
        public String name;
        public String nikeName;
        public HeroNode next;       //指向下一个节点，默认为null

        //构造器
        public HeroNode(int no, String name, String nikeName) {
            this.no = no;
            this.name = name;
            this.nikeName = nikeName;
        }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}

