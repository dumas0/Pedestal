package com.dumas.pedestal.ms.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 * @author dumas
 * @date 2021/12/17 4:06 PM
 */
public class BucketSortSolution {

    public static void bucketSort(int[] arr){
        // 计算最大值和最小值
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<>());
        }
        
        // 将每个元素放入桶中
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        
        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        
        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr = {11, 18, 23, 28, 45, 50};
        int[] arr = {18, 11, 28, 45, 23, 50};
        bucketSort(arr);
        System.out.println("桶排序的结果：" + Arrays.toString(arr));
    }
}
