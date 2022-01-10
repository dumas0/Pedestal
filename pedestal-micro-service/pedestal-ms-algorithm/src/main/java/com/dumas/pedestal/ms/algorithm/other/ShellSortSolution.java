package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;

/**
 * 希尔排序
 * @author dumas
 * @date 2021/12/17 3:31 PM
 */
public class ShellSortSolution {
    public void shellSort(int[] array){
        int dk = array.length / 2;
        while(dk >= 1){
            shellInsertSort(array, dk);
            dk = dk / 2;
        }
    }

    private void shellInsertSort(int[] array,int dk){
        for(int i = dk; i < array.length; i++){
            if(array[i] < array[i - dk]){
                int j, x = array[i];
                array[i] = array[i - dk];
                for(j = i - dk; j >= 0 && x < array[j]; j = j -dk){
                    array[j + dk] = array[j];
                }
                array[j + dk] = x;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5};
        System.out.println("希尔排序结果：" + Arrays.toString(arr));
    }
}
