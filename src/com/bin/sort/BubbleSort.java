package com.bin.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Date: 2022/05/20/16:28
 * @Description:    冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        //创建一个数组并为数组赋值
        int[] array = new int[10];

        for (int i = 0; i < array.length;i++){
            array[i] = (int)(Math.random() * 800000);
        }


//       统计方法执行时间，显示为秒级别
        long startTime=System.currentTimeMillis();

        bubbleSort(array);  //运行冒泡排序

        long endTime=System.currentTimeMillis();
        float useTime=(float)(endTime-startTime)/1000;

        System.out.println("执行时间："+useTime+"s" );
    }

    static void bubbleSort(int[] array){
        boolean flag = false;       // 初始化标记为false
        for (int i = 0;i < array.length - 1;i++){
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]){
                    // 交换a[j]和a[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    flag = true;        // 若发生交换，则设标记为true
                }
            }
            System.out.printf("第%d次排序后的数组",i+1);
            System.out.println(Arrays.toString(array));

            if (!flag){     //在一次排序中一次交换都没有发生过
                break;
            }else {
                flag = false;
            }
        }
    }
}





