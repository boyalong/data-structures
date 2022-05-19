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
        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[3][3] = 1;
        map[2][3] = 1;
        map[2][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        setWay(map,1,1);

        System.out.println("小球走过，并标识过的地图的情况");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    /**
     *
     * @param map 哪个地图
     * @param i ,j  地图位置
     * @return 找到返回true，否则false
     */
    public static boolean setWay(int[][] map, int i,int j){
        if(map[6][5] == 2){ //通道已经找到
            return true;
        }else{
            if (map[i][j] == 0){        //当前这个点还没走过
                //按照策略下 -> 右 -> 上 -> 左
                map[i][j] = 2;  //该点可走通
                if(setWay(map, i +1 , j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{  //该路是死路
                    map[i][j] = 3;
                    return  false;
                }
            }else {     //如果map[i][j] != 0,可能是1，2，3
                return false;
            }
        }
    }
}
