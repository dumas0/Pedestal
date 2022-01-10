package com.dumas.pedestal.ms.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 次数超一半的数
 * @author dumas
 * @date 2021/12/20 4:04 PM
 */
public class MajorityElementSolution {
    /**
     * 题目:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     *  输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]输出: 2
     * 分析：
     *  摩尔投票法
     *      - 初始化：cur记录当前数字和count记录当前数字出现的次数
     *      - 处理情况：遍历数组
     *          - count==0时，更新cur==num
     *          - 更新cur完毕后，如果再遇到cur==num，count+1；否则count-1
     *      - 返回：最后返回cur
     *   排序法
     *      - 数组中次数超过一半的数字，一定在排序后的数组中的中间位置，直接返回中间位置即可
     *   Hash法
     *      - 遍历数组，使用哈希表统计<元素，次数>，同时比较次数最大值
     *      - 遍历哈希表，取出次数最大值的key，就是次数超过一半的数字
     */

    // 方法1:摩尔投票法**
    // 出现次数超过一半的数，一定不会被抵消掉，最后留下的一定是它
    public int moreThanHalfNum(int[] nums){
        int cur = 0, count = 0;
        for(int num:nums){
            if(count == 0 ){
                cur = num;
            }
            if(cur == num){
                count++;
            }else{
                count--;
            }
        }
        return cur;
    }

    // 方法2:排序法
    public int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 方法3:哈希法
    public int majorityElement2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num) + 1);
                maxCount = Math.max(maxCount, map.get(num));
            }
        }
        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()){
            if(entrySet.getValue() == maxCount){
                return entrySet.getKey();
            }
        }
        throw new RuntimeException("not element");
    }


    public static void main(String[] args) {

    }
}
