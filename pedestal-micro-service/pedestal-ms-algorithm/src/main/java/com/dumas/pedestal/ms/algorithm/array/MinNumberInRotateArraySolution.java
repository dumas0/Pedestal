package com.dumas.pedestal.ms.algorithm.array;

/**
 * 旋转数组的最小值
 * @author dumas
 * @date 2021/12/13 2:27 PM
 */
public class MinNumberInRotateArraySolution {
    /**
     * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
     * 示例 1：
     *      输入：[3,4,5,1,2]
     *      输出：1
     * 示例 2：
     *      输入：[2,2,2,0,1]
     *      输出：0
     * 分析：
     *  正常递增数组查找某个元素，确定好target就行，使用二分法就好
     *  旋转递增数组的一部分，说明某一部分一定是递增排序好的，定义target=右边界值来二分
     *      - 小于，和未旋转二分查找类似=最小值在左边，但因为要包含右边界确定target，所以right=mid
     *      - 大于，最小值在右边，mid已经检查过，left=mid+1
     *      - 等于，无法确定最小值在左边还是右边，前移右边界重新循环，right-–
     *    示例一 [1, 0, 1, 1, 1] 示例二 [1, 1, 1, 0, 1]
     *      循环条件left<rightorleft<=right皆可，但返回值一定是nums[left]，因为最小值一定先碰到left
     *      返回值：二分结束，left指向旋转数组最小值，返回nums[left]
     */

    /**
     * 剑指11 旋转数组的最小值
     */
    public static int minArray(int[] numbers){
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int target = numbers[right];
            if(numbers[mid] < target){
                right = mid;
            }else if(numbers[mid] > target){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * 牛客JZ6
     */
    public static int minNumberInTotateArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int target = arr[right];
            if(arr[mid] > target){
                left = mid + 1;
            }else if(arr[mid] < target){
                right = mid;
            }else{
                right--;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {

    }
}
