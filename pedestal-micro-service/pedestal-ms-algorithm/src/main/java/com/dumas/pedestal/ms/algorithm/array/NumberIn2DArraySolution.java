package com.dumas.pedestal.ms.algorithm.array;

/**
 * 二维数据的查找
 * @author dumas
 * @date 2021/12/13 10:38 AM
 */
public class NumberIn2DArraySolution {
    /**
     * 题目:在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 示例:
     *      现有矩阵 matrix 如下：
     *         [
     *          [1,   4,  7, 11, 15],
     *          [2,   5,  8, 12, 19],
     *          [3,   6,  9, 16, 22],
     *          [10, 13, 14, 17, 24],
     *          [18, 21, 23, 26, 30]
     *         ]
     * 分析：双指针
     *  因为二维数组行列值都是递增的，首选二分法
     *  双指针问题：以左下角坐标[matrix.len-1][0]开始进行二分查找
     *  - 小于，列+1
     *  - 大于，行-1
     *  - 等于，皆大欢喜直接返回true
     */

    /**
     * 剑指04 二维数据的查找
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 ){
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j <= matrix[0].length - 1){
            if(matrix[i][j] < target){
                j++;
            }else if(matrix[i][j] > target){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 牛客JZ1
     */
    public static boolean find(int[][] array, int target){
        if(array == null && array.length == 0){
            return false;
        }
        int m = array.length - 1;
        int n = 0;
        while(n >= 0 && m <= array[0].length - 1){
            if(array[m][n] > target){
                m--;
            }else if(array[m][n] < target){
                n++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
