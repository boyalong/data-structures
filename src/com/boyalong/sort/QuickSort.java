package com.boyalong.sort;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Description:    快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        创建一个数组并为数组赋值
//        int[] array = new int[100];
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int) (Math.random() * 100000);
//        }
        int[] array = {1,5,2,4,6,3};

        System.out.println("排序前的数组:" + Arrays.toString(array));

//       统计方法执行时间，显示为秒级别
        long startTime = System.currentTimeMillis();

        quickSort1(array,0,array.length-1);

        long endTime = System.currentTimeMillis();
        float useTime = (float) (endTime - startTime) / 1000;

        System.out.println("排序后的数字：" + Arrays.toString(array));

        System.out.println("执行时间：" + useTime + "s");
    }

    public static void quickSort1(int[] array,int left,int right){
        int l = left;       //左下表
        int r = right;      //右下表
        //pivot 中轴值
        int pivot = array[(left + right) / 2];
        int temp = 0;  //临时变量
        //while循环让比pivot小的值放其左边，比pivot大的值放其右边
        while (l < r){
            //在pivot左边一直找，找到大于等于pivot的值才退出
            while (array[l] < pivot){
                l += 1;
            }
            //在pivot左边一直找，找到小于等于pivot的值才退出
            while (array[r] > pivot){
                r -= 1;
            }
            if(l >= r){
                break;
            }
            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if(array[l] == pivot){
                r -= 1;
            }
            if(array[r] == pivot){
                l += 1;
            }


            // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归
            if(left < r) {
                quickSort1(array, left, r);
            }
            //向右递归
            if(right > l) {
                quickSort1(array, l, right);
            }
        }
    }

    public static void quickSort2(int[] array,int l,int h){
        if(l >= h){
            return;
        }
        int p = partition(array, l, h);
        quickSort2(array, l, p-1);
        quickSort2(array, p+1, h);
    }

    public static int partition(int[] array,int l,int h){
        int pivot = array[h];
        int i = l;
        for (int j = l;j < h;j++){
            if(array[j] < pivot){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
        }

        int temp = array[i];
        array[i] = array[h];
        array[h] = temp;

        return i;
    }
}
