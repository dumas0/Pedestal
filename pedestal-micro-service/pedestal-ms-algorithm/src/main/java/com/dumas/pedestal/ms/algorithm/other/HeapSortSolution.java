package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;

/**
 * 堆排序
 * @author dumas
 * @date 2021/12/17 5:12 PM
 */
public class HeapSortSolution {

    public static void headSort(int[] arr){
        // 构建大顶堆
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
        // 调整堆结构，交换堆顶元素与末尾元素
        for(int j = arr.length - 1; j > 0; j--){
            // 交换堆顶元素和末尾元素
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k = i*2 + 1; k < length; k = k*2 + 1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {20, 40, 30, 10, 60, 50};
        headSort(arr);
        System.out.println("堆排序的结果：" + Arrays.toString(arr));
    }
}
