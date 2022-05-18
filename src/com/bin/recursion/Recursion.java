package com.bin.recursion;

/**
 * @Author: boyalong
 * @Date: 2022/05/18/21:12
 * @Description:
 */
public class Recursion {
    public static void main(String[] args) {
        test(4);

//        System.out.println(factorial(4));
    }

    static void test(int n){
        if(n > 2){
            test(n-1);
        }
        System.out.println(n);
    }
    //阶乘
    static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return factorial(n-1) * n;
        }
    }
}


