package com.dumas.pedestal.ms.algorithm.array;

/**
 * 数组中重复的数字
 * @author dumas
 * @date 2021/12/13 9:53 AM
 */
public class RepeatNumberSolution {
    /**
     * 题目：找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * 示例 1：
     *      输入：
     *      [2, 3, 1, 0, 2, 5, 3]
     *      输出：2 或 3
     * 分析：
     *  条件给了数组长度为n，元素范围为0到n-1，显然是想让我们使用下标和元素值对应
     *  - 数字存在重复，很容易想到index==nums[index],第一次遇到肯定是不返回
     *  - 当index!=nums[index]
     *      - 第二次遇见nums[index]==nums[nums[index]],就是该元素重复，直接返回
     *      - 否则，即不是未重复的也不是下标对应的，那就是未排序乱序的其他元素，交换nums[index]与index上元素，使其归位
     */

    /**
     * 剑指03
     * 题目：nums长度为n，数字为0到n-1，有些数字重复了，找出任意重复的一个数字
     * 方法:数组下标与元素对应
     */
    public static int findRepeatNumber(int[] nums){
        int index = 0;
        while(index < nums.length){
            // 元素值和坐标对应，遍历指针后移+进行下次循环
            if(nums[index] == index){
                index++;
                continue;
            }
            // 当元素值和坐标不对应
            // 情况1：第二次来到该位置，就是重复元素
            if(nums[index] == nums[nums[index]]){
                return nums[index];
            }else{
                // 情况2：归位，让其归位到第一次出现的位置
                int temp = nums[index];
                nums[index] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 牛客JZ50
     */
    public static int duplicate(int[] nums){
        int index = 0;
        // 不能用for，因为只有index == nums[index]才index++
        while(index <= nums.length - 1){
            // 元素值和坐标对应，遍历指针后移+进行下次循环
            if(index == nums[index]){
                index++;
                continue;
            }
            // 当元素值和坐标不对应
            // 情况1：第二次来到该位置，就是重复元素
            if(nums[index] == nums[nums[index]]){
                return nums[index];
            }else{
                // 情况2：归位，让其归位到第一次出现的位置
                int temp = nums[index];
                // temp既是记录数还是记录下标
                nums[index] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("剑指03 数组中重复的数字:" + findRepeatNumber(arr));
        System.out.println("牛客JZ50 数组中重复的数字:" + findRepeatNumber(arr));
    }
}
