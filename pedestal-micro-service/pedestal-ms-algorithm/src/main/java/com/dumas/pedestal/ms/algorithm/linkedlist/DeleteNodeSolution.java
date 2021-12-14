package com.dumas.pedestal.ms.algorithm.linkedlist;

/**
 * 删除链表结点
 * @author dumas
 * @date 2021/12/14 2:09 PM
 */
public class DeleteNodeSolution {
    /**
     * 题目：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
     * 示例 1:
     *  输入: head = [4,5,1,9], val = 5输出: [4,1,9]解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *  输入: head = [4,5,1,9], val = 1输出: [4,5,9]解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * 说明：
     *  题目保证链表中节点的值互不相同
     *  若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     */

    /**
     * 法1：双指针版，pre和cur
     * 剑指18 删除链表结点
     */
    public ListNode deleteNode1(ListNode head, int val){
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            pre.next = cur.next;
        }
        return head;
    }

    /**
     * 法2：单指针版，cur遍历到待删除结点的前一个位置
     * 剑指18 删除链表结点
     */
    public ListNode deleteNode2(ListNode head, int val){
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode cur = head;
        while(cur.next != null && cur.next.val != val){
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
