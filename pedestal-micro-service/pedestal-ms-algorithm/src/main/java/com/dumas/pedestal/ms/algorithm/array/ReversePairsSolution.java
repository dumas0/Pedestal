package com.dumas.pedestal.ms.algorithm.array;

/**
 * 数组中的逆序对(***)
 * @author dumas
 * @date 2021/12/20 4:58 PM
 */
public class ReversePairsSolution {
    /**
     * 题目：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
     * 示例 1:
     *  输入: [7,5,6,4]输出: 5
     * 分析：
     *  逆序对问题，对应的就是归并排序，改变归并排序的一行代码即可
     *  - 归并排序中merge中，合并两个数组到一个数组时，出现前面>后面，这时候的差值就是该论逆序对的数量
     *  - Debug记录下计算的过程：条件，给arr={4,3,2,1}
     *  - {4,3}：4>3，形成一个逆序对，数组变成{3,4}。{2,1}：形成一个逆序对，数组变成{1,2}
     *  - {3,4,1,2}：3和1比较，3>1，形成2个逆序对；3和2比较，形成2个逆序对；
     *  - 数组归并为{1,2,3,4}，结束
     */
    private static int res;

    public int reversePairs(int[] nums){
        int[] temp = new int[nums.length];
        res = 0;
        mergeSort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private static void mergeSort(int[] nums, int l, int r, int[] temp){
        if(l >= r){
            return;
        }
        int mid = l + (r -l) / 2;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid + 1, r, temp);
        if(nums[mid] > nums[mid + 1]){
            merge(nums, l, mid, r, temp);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r, int[] temp){
        System.arraycopy(nums,l, temp, l,r - l + 1);
        int p = l, q = mid + 1;
        for(int i = l; i <= r; i++){
            if(p > mid){
                nums[i] = temp[q++];
            }else if(q > r){
                nums[i] = temp[p++];
            }else if(temp[p] <= temp[q]){
                nums[i] = temp[p++];
            }else{
                res += mid - p + 1;
                nums[i] = temp[q++];
            }
        }
    }

    public static void main(String[] args) {

    }
}
