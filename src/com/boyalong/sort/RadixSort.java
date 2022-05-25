package com.boyalong.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Date: 2022/05/25/22:10
 * @Description: 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        //创建一个数组并为数组赋值
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }

        System.out.println("排序前的数组:" + Arrays.toString(array));

//       统计方法执行时间，显示为秒级别
        long startTime = System.currentTimeMillis();

        radixSort(array);  //运行冒泡排序

        long endTime = System.currentTimeMillis();
        float useTime = (float) (endTime - startTime) / 1000;

        System.out.println("排序后的数字：" + Arrays.toString(array));

        System.out.println("执行时间：" + useTime + "s");
    }

    public static void radixSort(int[] array) {
        //得到数组中位数最大的数,并获取它的位数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        int[][] bucket = new int[10][array.length];

        //定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素的对应位数进行排序处理
            for (int j = 0; j < array.length; j++) {
                //取出对应元素的对应位的值
                int digitOfElement = array[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index = 0;
            //遍历每一个桶，并将桶中数据放入原数组中
            for (int k = 0; k < bucket.length;k++){
                //如果桶中含数据，才放入原数组
                if(bucketElementCounts[k] != 0){
                    //循环该桶第k个桶，放入
                    for (int l = 0; l < bucketElementCounts[k];l++){
                        //取出元素放入array
                        array[index++] =bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }


    }

}
