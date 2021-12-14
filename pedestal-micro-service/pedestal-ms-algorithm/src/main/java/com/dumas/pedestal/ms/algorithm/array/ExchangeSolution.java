package com.dumas.pedestal.ms.algorithm.array;

/**
 * 奇数位于偶数前面
 * @author dumas
 * @date 2021/12/14 10:58 AM
 */
public class ExchangeSolution {
    /**
     * 题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：
     *  输入：nums = [1,2,3,4]
     *  输出：[1,3,2,4]
     *  注：[3,1,2,4] 也是正确的答案之一。
     * 分析：
     *  双指针，i遍历前面，j遍历后面
     *      - i遇到非偶数就后移，j遇到偶数就前移
     *  遍历到i=j就结束,因为一个数不用交换,所以循环条件是while(i<j)
     */

    /**
     * 剑指21 奇数位于偶数前面
     */
    public static int[] exchange(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left < right && (nums[left] % 2) != 0){
                left++;
            }
            while(left < right && (nums[left] % 2) == 0 ){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    /**
     * 牛客JZ13
     * 注意：牛客此题要求保持奇偶相对次序不改变
     */
    public static int[] reOrderArray(int[] array){
        int[] res = new int[array.length];
        int index = 0;
        for(int num : array){
            if(num % 2 != 0){
                res[index++] = num;
            }
        }
        for(int num : array){
            if(num % 2 == 0 ){
                res[index++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
