package com.boyalong.josepfu;

/**
 * @Author: boyalong
 * @Description: 约瑟夫环
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();
        circleSingleLinkList.addBoy(5);
//        circleSingleLinkList.showBoy();

        circleSingleLinkList.countBoy(1,2,1);
    }

}


/**
 * 创建一个环形单向链表
 */
class CircleSingleLinkList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(1);
    //添加Boy节点，构成一个环形的链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;      //辅助指针
        //使用for循环来创建我们的环形链表
        for(int i = 1;i <= nums ;i++){
            //根据编号创造Boy节点
            Boy boy = new Boy(i);
            //如果是第一个boy
            if(i == 1){
                first = boy;
                first.setNext(first);//形成一个闭环
                curBoy = first;     //让curBoy指向第一个boy
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前链表
    public void showBoy(){
        //判断链表是否为空
            if (first == null){
                System.out.println("没有任何boy");
                return;
            }
            //因为first不能动，因此我们仍使用一个辅助指针完成遍历
        Boy curBoy = first;
            while (true){
                System.out.printf("小孩的编号为%d \n",curBoy.getNo());
                if(curBoy.getNext() == first){
                    break;
                }
                curBoy = curBoy.getNext();
            }
    }

    /**
     *
     * @param starNo    开始的小孩编号
     * @param countNum      每次数的数
     * @param nums      一共几个小孩
     */
    public void countBoy(int starNo,int countNum, int nums){
        //对数据进行校验
        if(first == null || starNo < 1 || starNo > nums){
            System.out.println("输入的参数有误，请重新输入");
            return;
        }
        Boy helper = first;     //创建辅助指针helper，使期指向链表最后一个节点
        while (true){
            if( helper.getNext() == first){      //
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动 k - 1 次
        for (int j = 0; j < starNo - 1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动countNum-1次，然后出圈
        while (true){
            if ( helper == first ){
                break;
            }
            for (int j = 0;j < countNum -1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("恭喜小孩%d成功吃鸡",first.getNo());
    }

}

/**
 * 创建一个Boy表示一个节点
 */
class Boy{
    private int no;     //编号

    private Boy next;       //指向下一个节点，默认null

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
