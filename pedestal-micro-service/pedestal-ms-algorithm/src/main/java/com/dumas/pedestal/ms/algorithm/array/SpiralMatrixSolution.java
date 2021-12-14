package com.dumas.pedestal.ms.algorithm.array;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵(螺旋矩阵)
 * @author dumas
 * @date 2021/12/14 11:10 AM
 */
public class SpiralMatrixSolution {
    /**
     * 题目:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 示例 1：
     *  输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *  输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * 分析：
     *  数组为空，返回空的一维数组
     *  初始化左上角坐标(tR,tC)=(0,0)，右下角坐标(dR,dC)=( matrix.length - 1,matrix[0].length - 1)
     *  初始化 res[matrix.length*matrix[0].length]和遍历index
     *  循环条件while (tR <= dR && tC <= dC)，因为赋值给res时一个点也可以赋值
     *      - 特殊情况：tR==dR或tC==dC，简单遍历赋值即可
     *      - 一般情况：保证顺时针，生成一个遍历坐标（curR,curC）
     *          - 左到右：先固定tR，动curC++
     *          - 上到下：固定dC，动curR++
     *          - 右到左：固定dR，动curC- -
     *          - 下到上：固定tC，动curR- -
     *          - curR,curC遍历时，遍历条件是！=即可，不能遍历到端点
     */

    /**
     * 剑指29 顺时针打印矩阵
     */
    public int[] spiralOrder(int[][] matrix){
        if(matrix.length == 0){
            return new int[0];
        }
        int tR = 0,tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        while(tR <= dR && tC <= dC){
            index = spiralMatrix(matrix, index, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private int spiralMatrix(int[][] matrix, int index, int[] res, int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                res[index++]  = matrix[tR][i];
            }
        }else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                res[index++] = matrix[i][tC];
            }
        }else{
            for(int i = tC; i < dC; i++){
                res[index++] = matrix[tR][i];
            }
            for(int i = tR; i < dR; i++){
                res[index++] = matrix[i][dC];
            }
            for(int i = dC; i > tC; i--){
                res[index++] = matrix[dR][i];
            }
            for(int i = dR; i > tR; i--){
                res[index++] = matrix[i][tC];
            }
        }
        return index;
    }

    /**
     * 牛客JZ19
     */
    public ArrayList<Integer> printMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            print(matrix, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private void print(int[][] matrix, ArrayList<Integer> res, int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                res.add(matrix[tR][i]);
            }
        }else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                res.add(matrix[i][tC]);
            }
        }else{
            for (int i = tC; i < dC; i++) {
                res.add(matrix[tR][i]);
            }
            for (int i = tR; i < dR; i++) {
                res.add(matrix[i][dC]);
            }
            for (int i = dC; i > tC; i--) {
                res.add(matrix[dR][i]);
            }
            for (int i = dR; i > tR; i--) {
                res.add(matrix[i][tC]);
            }
        }
    }

    public static void main(String[] args) {
        SpiralMatrixSolution solution = new SpiralMatrixSolution();
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> res = solution.printMatrix(m);
        // 正确：[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        System.out.println(res);
    }
}
