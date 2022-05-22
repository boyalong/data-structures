package com.bin.aMyDemo;

/**
 * @Author: boyalong
 * @Date: 2022/05/21/19:01
 * @Description: 查询 a中数据 包含 b中数据 的个数
 */
public class demo {

    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7, 9, 0};
        int[] b = {2, 4, 6, 8, 0, 1, 3};

        boolean[] array = new boolean[10];    //建立一个长度为10的Boolean数组，默认为false

        int x = 0;

        for (int i = 0; i < a.length; i++) {
            array[a[i]] = true;   //让array数组中下标为a[i]的数据false -> true
        }
        for (int i = 0; i < b.length; i++) {
            if (array[b[i]] == true) {     //遍历array数组中下标为b[i]的数据是否为true
                x++;     //统计个数
            }
        }
        System.out.println(x);
    }
}
