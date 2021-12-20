package com.dumas.pedestal.ms.algorithm.array;

/**
 * 排序数组中查找数字
 * @author dumas
 * @date 2021/12/20 5:20 PM
 */
public class GetNumberOfKSolution {
    /**
     * 题目:统计一个数字在排序数组中出现的次数。
     * 示例 1:
     *  输入: nums = [5,7,7,8,8,10], target = 8输出: 2
     * 示例 2:
     *  输入: nums = [5,7,7,8,8,10], target = 6输出: 0
     * 分析：
     *  [5,7,7,8,8,10],t=8的出现的次数 = 10的下标-第一个8的下标 = 大于8的第一个数索引-大于7的第一个数索引
     *  定义一个函数获取>k元素的第一个数索引，>k-1元素的第一个索引
     *  注意：left≤right，因为等于时，也是一个数量次数不能忽略
     */

    // 问题:在排序数组中统计数字出现的次数
    // 二分法:因为数组有序找target,思考用二分法
    public int search(int[] nums, int target){
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }

    private int getRightMargin(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3};
        GetNumberOfKSolution solution = new GetNumberOfKSolution();
        System.out.println("排序数组中查找数字结果：" + solution.search(arr, 3));
    }

}
