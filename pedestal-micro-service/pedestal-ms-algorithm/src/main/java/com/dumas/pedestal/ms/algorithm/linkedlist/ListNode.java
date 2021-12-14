package com.dumas.pedestal.ms.algorithm.linkedlist;

/**
 * @author dumas
 * @date 2021/12/14 1:49 PM
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
