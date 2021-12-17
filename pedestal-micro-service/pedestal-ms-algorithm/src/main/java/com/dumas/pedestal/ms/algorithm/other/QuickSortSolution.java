package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;

/**
 * 快速排序
 * @author dumas
 * @date 2021/12/17 3:15 PM
 */
public class QuickSortSolution {

    public static void quickSort(int[] array, int low, int high){
        int start = low;
        int end = high;
        int key = array[low];
        while(end > start){
            while(end > start && array[end] >= key){
                end--;
                if(array[end] <= key){
                    int temp = array[end];
                    array[end] = array[start];
                    array[start] = temp;
                }
            }
            while(end > start && array[end] <= key){
                start++;
                if (array[start] >= key) {
                    int temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                }
            }
            if(start > low){
                quickSort(array, low, start - 1);
            }
            if(end < high){
                quickSort(array, end + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序结果：" + Arrays.toString(arr));
    }
}
