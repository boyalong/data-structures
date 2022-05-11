package com.bin.sparseArray;

/**
 * @Author: boyalong
 * @Date: 2022/05/10/15:06
 * @Description: 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个11 * 11原始的二维数组
        //黑棋为1，白棋为2
        int chessArr1[][] =new int[11][11];
        chessArr1[1][2] = 1;//第2行第3列一个黑棋
        chessArr1[2][3] = 2;//第3行第4列一个白棋
        chessArr1[6][6] = 1;
        //遍历输出二维数组
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println("===================================");

        //遍历二维数组每有一个非0数sum++
        //稀疏数组的长度为sum+1
        int sum = 0;
        for (int i = 0;i < 11;i++){
            for (int j = 0;j < 11;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        int sparseArray[][] = new int[ sum + 1][3];
        //稀疏数组第0行所展示的数据
        sparseArray[0][0] = chessArr1.length;//二维数组总行数
        sparseArray[0][1] = chessArr1.length;//二维数组总列数
        sparseArray[0][2] = sum;//非零值数目（棋子数）

        //遍历二维数组，将非0的值传入稀疏数组
        int row = 0;
        for (int i = 0;i < 11;i++){
            for (int j = 0;j < 11;j++){
                if(chessArr1[i][j] != 0){
                    row++;
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("得到的稀疏数组为: ");
//        遍历循环输出数组
        for (int i = 0;i < sparseArray.length;i++){
                System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        System.out.println("还原后的二维数组为: ");
        System.out.println("=============================");
        //将稀疏数组转为二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i =1;i < sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }
}
