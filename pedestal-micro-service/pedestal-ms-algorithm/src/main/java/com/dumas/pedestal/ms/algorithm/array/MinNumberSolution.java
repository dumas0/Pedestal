package com.dumas.pedestal.ms.algorithm.array;

import java.util.Arrays;

/**
 * 数组排成最小的数
 *
 * @author dumas
 * @date 2021/12/20 4:29 PM
 */
public class MinNumberSolution {
    /**
     * 题目：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
     * 示例 1:
     * 输入: [10,2]输出: "102"
     * 示例 2:
     * 输入: [3,30,34,5,9]输出: "3033459"
     * 提示: 0 < nums.length <= 100
     * 说明:输出结果可能非常大，所以你需要返回一个字符串而不是整数拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
     * 分析：
     * 两个字符比较，按照小大排序的比较规则是：(x, y) -> (x + y).compareTo(y + x)
     * - (x+y)<(y+x)，则x排序y的前面
     * - (x+y)>(y+x)，则x排序y的后面
     * - 证明见力扣题解评论区：如下https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
     * 将nums数组转换为字符数组
     * 利用库排序函数Array.sort()将字符数组按照上诉的比较器规则进行比较
     * 将排序后的字符串数组，转换为字符串，就是排成的最小数
     */
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    // 手写比较逻辑，速度较慢
    public String minNumer2(int[] nums){
        if(nums == null || nums.length == 0){
            return "";
        }
        // 冒泡排序寻找最小值
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int x = nums[i];
                int y = nums[j];
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                if(num1 > num2){
                    nums[i] = y;
                    nums[j] = x;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num:nums){
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
