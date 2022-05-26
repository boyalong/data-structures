package com.boyalong.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: boyalong
 * @Date: 2022/05/23/19:09
 * @Description:    二分查找（要求为有序列表）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};

        int i = binarySearch(array, 0, array.length - 1, 5);
        List<Integer> j = binarySearch2(array, 0, array.length - 1, 3);
        int x = binarySearch3(array, 0, array.length - 1, 3);
        System.out.println(i);
    }


    /**
     * 递归实现
     * @param array
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] array,int left,int right, int findVal){

        //当left>right时，说明递归整个数组，但没有找到

        if(left > right){
            return -1;
        }

        int mid = left +(right - left)/2;

        if(findVal < array[mid]){   // 向左递归
            return binarySearch(array, left,mid - 1,findVal);
        }else if(findVal > array[mid]){     // 向右递归
            return binarySearch(array,mid + 1,right,findVal);
        }else {
            return mid;
        }

    }

    /**
     * 查找多个数
     * @param array
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch2(int[] array,int left,int right, int findVal){

        //当left>right时，说明递归整个数组，但没有找到
        if(left > right){
            return new ArrayList<>();
        }

        int mid = left +(right - left)/2;

        if(findVal < array[mid]){       //像左递归
            return binarySearch2(array, left,mid - 1,findVal);
        }else if(findVal > array[mid]){     //像右递归
            return binarySearch2(array,mid + 1,right,findVal);
        }else {

            List<Integer> resIndexList = new ArrayList<>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while (true){
                if(temp < 0 || array[temp] != findVal){
                    break;
                }
                //否则，就temp 放入到 resIndexList
                resIndexList.add(temp);
                temp -= 1;  //temp左移
            }

            resIndexList.add(mid);

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp= mid + 1;
            while (true){
                if(temp > array.length-1 || array[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                //否则，就temp 放入到 resIndexList
                temp += 1;      //temp右移
            }

            return resIndexList;
        }
    }


    /**
     * 非递归实现
     * @param array
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch3(int[] array, int left ,int right,int findVal) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (findVal < array[mid]){
                right = mid - 1;
            }else if (findVal > array[mid]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
