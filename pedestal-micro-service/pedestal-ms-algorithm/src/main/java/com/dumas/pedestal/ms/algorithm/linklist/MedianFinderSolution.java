package com.dumas.pedestal.ms.algorithm.linklist;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * @author dumas
 * @date 2021/12/16 3:12 PM
 */
public class MedianFinderSolution {
    /**
     * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 例如，
     *  [2,3,4] 的中位数是 3[2,3] 的中位数是 (2 + 3) / 2 = 2.5
     * 设计一个支持以下两种操作的数据结构
     *  void addNum(int num) - 从数据流中添加一个整数到数据结构中。double findMedian() - 返回目前所有元素的中位数。
     * 例1：
     *  输入：["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"][[],[1],[2],[],[3],[]]
     *  输出：[null,null,null,1.50000,null,2.00000]
     * 例1：
     *  输入：["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"][[],[1],[2],[],[3],[]]
     *  输出：[null,null,null,1.50000,null,2.00000]
     * 分析：
     *  如果是一个排序后的数组求中位数，可以直接计算出来，但是这里是流动的数据流，想降低时间复杂度，可以使用两个堆维持数据
     *  大根堆存较小的N/2个数，小根堆存较大的N/2个数
     *  第一个出现的数先加入大根堆，以后每次加入的数≤大根堆堆顶也加入大根堆。否则加入小根堆
     *  每次加入一个数后，如果两个堆长度差达到2，就将大的出一个数加入小的堆里
     *  任何时候，数据流的中位数就可以由两个堆顶获得
     */
    private Queue<Integer> maxHeap;// 大根堆存较小的N/2个数
    private Queue<Integer> minHeadp;// 小根堆存较小的N/2个数

    public MedianFinderSolution(){
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeadp = new PriorityQueue<>();
    }

    public void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeadp.add(num);
        }
        modifyHeap();
    }

    private void modifyHeap(){
        if(maxHeap.size() == minHeadp.size() + 2){
            minHeadp.add(maxHeap.poll());
        }
        if(minHeadp.size() == maxHeap.size() + 2){
            maxHeap.add(minHeadp.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.isEmpty()){
            return -1.0;
        }
        if(maxHeap.size() == minHeadp.size()){
            return (maxHeap.peek() + minHeadp.peek()) / 2.0000;
        }else{
            return maxHeap.size() > minHeadp.size() ? maxHeap.peek() : minHeadp.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinderSolution solution = new MedianFinderSolution();
        solution.addNum(2);
        solution.addNum(3);
        System.out.println(solution.findMedian());
        solution.addNum(4);
        System.out.println(solution.findMedian());
    }

}
