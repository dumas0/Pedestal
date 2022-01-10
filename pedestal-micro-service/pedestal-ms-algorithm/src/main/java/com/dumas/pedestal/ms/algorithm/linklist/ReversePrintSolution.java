package com.dumas.pedestal.ms.algorithm.linklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从头到尾打印链表
 * @author dumas
 * @date 2021/12/14 1:42 PM
 */
public class ReversePrintSolution {
    /**
     * 题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     * 示例1：
     *  输入：head = [1,3,2]输出：[2,3,1]
     * 分析：
     *  辅助栈：最容易想到的方法，重点利用本题学习递归常见写法
     *  - 遍历链表，用栈记录节点值
     *  - 遍历栈，用一个数组记录栈顶的值，栈顶元素一次出栈
     */

    /**
     * 法1:辅助栈
     * 剑指06 从头到尾打印链表
     */
    public int[] reversePrint(ListNode head){
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * 法2:递归法,先理解辅助栈法,体会递归本质这种先进后出的思想
     * 递归法：先理解辅助栈法,体会递归本质这种先进后出的思想
     *  - 递归第一次到，不记录值，因为我们从尾到头打印
     *  - 递归第二次到，记录该节点值，放进一个List中
     *  - 遍历List大小的res数组，依次将值放入res中
     * 剑指06 从头到尾打印链表
     */
    public int[] reversePrint1(ListNode head){
        List<Integer> temp = new ArrayList<Integer>();
        reverse(head, temp);
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        return res;
    }

    private void reverse(ListNode node, List<Integer> temp){
        if(node == null){
            return;
        }
        reverse(node.next, temp);
        temp.add(node.val);
    }

    /**
     * 牛客JZ3
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if(listNode == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        process(listNode, res);
        return res;
    }

    private void process(ListNode node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        process(node.next, res);
        res.add(node.val);
    }

    public static void main(String[] args) {

    }
}
