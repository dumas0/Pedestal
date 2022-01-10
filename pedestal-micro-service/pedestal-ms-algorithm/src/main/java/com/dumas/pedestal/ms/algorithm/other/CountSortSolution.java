package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author dumas
 * @date 2021/12/17 5:10 PM
 */
public class CountSortSolution {

    public static int[] countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        int[] result = new int[arr.length];
        int index = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                result[index++] = i;
                count[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {20, 40, 30, 10, 60, 50};
        System.out.println("计数排序的结果：" + Arrays.toString(countSort(arr)));
    }
}
