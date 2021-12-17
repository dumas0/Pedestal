package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;

/**
 * 归并排序(分治思想)
 * @author dumas
 * @date 2021/12/17 3:44 PM
 */
public class MergeSortSolution {

    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, t = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i]++;
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        while(j <= right){
            temp[t++] = arr[j++];
        }
        // 复制临时数组数据到原数组
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr);
        System.out.println("归并排序的结果：" + Arrays.toString(arr));
    }
}
