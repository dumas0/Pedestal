package com.dumas.pedestal.ms.algorithm.array;

/**
 * 缺失的数字
 *
 * @author dumas
 * @date 2021/12/20 5:39 PM
 */
public class MissingNumberSolution {
    /**
     * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 示例 1:
     * 输入: [0,1,3]输出: 2
     * 示例 2:
     * 输入: [0,1,2,3,4,5,6,7,9]输出: 8
     * 分析：
     * 数组元素与下标对应完整,比如:[0]返回1,[0,1]返回2,[0,1,2]返回3
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i && i == nums.length - 1) {
                return nums.length;
            }
            if (nums[i] != i) {
                return nums[i] - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6, 7,8, 9};
        MissingNumberSolution solution = new MissingNumberSolution();
        System.out.println("缺失的数字结果：" + solution.missingNumber(arr));
    }
}
