package com.boyalong.search;

import java.util.Arrays;

/**
 * @Author: boyalong
 * @Date: 2022/05/26/11:13
 * @Description:    插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
           array[i] = i;
        }
        int index = insertValueSearch(array,0,array.length - 1,99);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] array,int left,int right,int findVal){
        if(left > right || findVal < array[0] || findVal > array[array.length - 1]){
            return -1;
        }

        //求出mid
        int mid = left + (right - left) * (findVal - array[left]) / (array[right] - array[left]);

        if(findVal > array[mid]){   //向右递归
            return insertValueSearch(array,mid + 1,right,findVal);
        } else if(findVal < array[mid]){    //向左递归
            return insertValueSearch(array, left,mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
