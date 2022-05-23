package com.bin.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Date: 2022/05/22/20:26
 * @Description:    插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        //创建一个数组并为数组赋值
        int[] array = new int[10000];

        for (int i = 0; i < array.length;i++){
            array[i] = (int)(Math.random() * 100000);
        }

        System.out.println("排序前的数组:" + Arrays.toString(array));

//       统计方法执行时间，显示为秒级别
        long startTime = System.currentTimeMillis();

        insertSort(array);

        long endTime = System.currentTimeMillis();
        float useTime = (float) (endTime-startTime)/1000;

        System.out.println("排序后的数字：" + Arrays.toString(array) );

        System.out.println("执行时间："+useTime+"s" );
    }

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0){
                if(array[j] > temp){
                    array[j + 1] = array[j];
                }else {
                    break;
                }
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
