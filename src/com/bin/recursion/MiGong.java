package com.bin.recursion;

/**
 * @Author: boyalong
 * @Date: 2022/05/19/10:47
 * @Description:
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个迷宫
        int[][] map = new int[8][7];
        //1表示墙,上下左右两行为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
