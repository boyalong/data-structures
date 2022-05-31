package com.boyalong.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        //创建一个数组并为数组赋值
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }

        System.out.println("排序前的数组:" + Arrays.toString(array));

//       统计方法执行时间，显示为秒级别
        long startTime = System.currentTimeMillis();

        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);  //运行冒泡排序

        long endTime = System.currentTimeMillis();
        float useTime = (float) (endTime - startTime) / 1000;

        System.out.println("排序后的数字：" + Arrays.toString(array));

        System.out.println("执行时间：" + useTime + "s");
    }

    /**
     * 分开+合并的方法
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int array[], int left, int right, int temp[]){
        if(left < right){
            int mid = left + (right - left) / 2;
            //向左递归进行分解
            mergeSort(array,left,mid,temp);
            //向右递归进行分解
            mergeSort(array,mid+1,right,temp);
            //合并
            merge(array,left,mid,right,temp);
        }
    }


    /**
     * 合并的方法
     *
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public static void merge(int array[], int left, int mid, int right, int temp[]) {
        int i = left;   //左边有序序列的初始索引
        int j = mid + 1;    //右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

        //把左右两边（有序）的数据按照规则填充到temp数组，直到有一边处理完为止
        while (i <= mid && j <= right) {  //没处理完，继续
            //当左边有序序列的当前元素，小于等于右边有序序列的当前元素，将左边的当前元素填充到temp数组
            //然后temp数组索引和左边有序序列索引+1
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }

//        把剩下的数据依次全部填充到temp
        while (i <= mid) {  //左边有剩余
            temp[t] = array[i];
            i += 1;
            t += 1;
        }

        while ( j <= right){
            temp[t] = array[j];    //右边有剩余
            j += 1;
            t += 1;
        }

        //将temp数组元素拷贝到arr
        //注：并不是每一次拷贝所有
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            array[tempLeft] = temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
