package com.dumas.pedestal.ms.algorithm.linklist;

import java.util.Arrays;

/**
 * 最小的k个数
 * @author dumas
 * @date 2021/12/16 10:23 AM
 */
public class QuickSortKSolution {
    /**
     * 题目：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
     * 示例 1：
     *  输入：arr = [3,2,1], k = 2输出：[1,2] 或者 [2,1]
     * 示例 2：
     *  输入：arr = [0,1,2,1], k = 1输出：[0]
     * 限制：
     *  0 <= k <= arr.length <= 100000 <= arr[i] <= 10000
     * 分析：
     *  快速排序思想法：最小k个数升序的查找，可以使用快速排序基准的思想，如果i==k，表示前k个数已经排好序，返回这k个数即可，但是有2个大坑需要注意一下
     *  大坑1：arr[L]作为基准，只能先移动j后移动i
     *      比如：arr={3,1,2,4,5},arr[L]=3,如果先i++,再j- -，再交换swap(ar,i,L),就变成了arr=[4,1,2,3,5],不符合基准量表左小右大的要求
     *      原因：arr[L]作为基准，必须先找到<区域的最后一个数位置，才能交换基准与该位置
     *  大坑2：swap中i与j可能越界
     *      arr = {4,5,1,6,2,7,3,8}，k=8，i最后只能=8来划分区间，此时是不能swap(arr,i,L)
     *      解决办法：swap函数中加如果i==j，就停止交换即可
     */

    public int[] getLeastNumbers(int[] arr, int k){
        if(k < 0 || k > arr.length){
            return new int[]{};
        }
        return quickSortK(arr, 0, arr.length - 1, k);
    }

    private int[] quickSortK(int[] arr, int L, int R, int k){
        int i = L;
        int j = R;
        // while循环,将arr划分为[l,i]<arr[l],arr[l],arr[i+1,r]>arr[l]
        while(i < j){
            // 注意：arr[L]作为基准，先移动j后移动i
            // 因为我只能和<区域最后一个交换才能保证左小右大，先移动j才能找到第一个<的数
            // 找到第一个arr[j]<arr[l]
            while(i < j && arr[j] >= arr[L]){
                j--;
            }
            // 找到第一个arr[i]>arr[l]
            while (i < j && arr[i] <= arr[L]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 交换基准arr[l]和arr[i],保证划分区间
        swap(arr, i, L);
        // 若i>k ，说明小于k个数的边界在左边，移动右边界
        if(i > k){
            quickSortK(arr, L, i - 1, k);
        }else if(i < k){
            // i<k，移动左边界
            quickSortK(arr, i + 1, R, k);
        }
        // 若i==k,前k个数就是k下标前面的所有数
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j){
        if(i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
