package com.boyalong.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Date: 2022/05/21/14:08
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        //创建一个数组并为数组赋值
        int[] array = new int[10000];

        for (int i = 0; i < array.length;i++){
            array[i] = (int)(Math.random() * 100000);
        }

        System.out.println("排序前的数组:" + Arrays.toString(array));

//       统计方法执行时间，显示为秒级别
        long startTime = System.currentTimeMillis();

        selectSort(array);

        long endTime = System.currentTimeMillis();
        float useTime = (float) (endTime-startTime)/1000;

        System.out.println("排序后的数字：" + Arrays.toString(array) );

        System.out.println("执行时间："+useTime+"s" );
    }


    public static void selectSort(int[] array) {

        for( int i = 0; i < array.length; i++) {
            int min = i;

            // 找出"a[i+1] ... a[n]"之间的最小元素，并赋值给min。
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;   //下标
                }
            }

            // 若min!=i，则交换 a[i] 和 a[min]。
            // 交换之后，保证了a[0] ... a[i] 之间的元素是有序的。
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }
}

