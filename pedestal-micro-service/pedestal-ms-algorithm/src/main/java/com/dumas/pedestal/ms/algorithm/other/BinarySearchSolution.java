package com.dumas.pedestal.ms.algorithm.other;

/**
 * 二分查找
 * @author dumas
 * @date 2021/12/17 2:11 PM
 */
public class BinarySearchSolution {

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 8};
        System.out.println("二分查找结果：" + binarySearch(arr, 8));
    }
}
