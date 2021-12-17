package com.dumas.pedestal.ms.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 基数排序法
 * @author dumas
 * @date 2021/12/17 4:33 PM
 */
public class RadixSortSolution {

    public static void radixSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        // 获取最大数的位数
        int num = 0;
        while(max != 0){
            max /= 10;
            num++;
        }

        // 创建10个桶
        int bucketNum = 10;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>();

        // 初始化桶
        for(int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<Integer>());
        }

        // 进行桶的每一趟排序
        for(int i = 0; i < num; i++){
            for(int j = 0; j < arr.length; j++){
                //获取最后一位数
                //如果是第二趟循环，就除以10然后再取余，这样子就可以实时获取固定位的数，而不改变原数组
                int radix = (int)(arr[j] / Math.pow(10, i)) % 10;
                //放进对应的桶里
                bucketList.get(radix).add(arr[j]);
            }

            // 合并原数组
            int k = 0;
            for(LinkedList<Integer> integers:bucketList){
                for(Integer integer : integers){
                    arr[k++] = integer;
                }
                //取出来之后将这个桶清空，供下一次循环使用
                integers.clear();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 40, 30, 10, 60, 50};
        radixSort(arr);
        System.out.println("基数排序的结果：" + Arrays.toString(arr));
    }
}
