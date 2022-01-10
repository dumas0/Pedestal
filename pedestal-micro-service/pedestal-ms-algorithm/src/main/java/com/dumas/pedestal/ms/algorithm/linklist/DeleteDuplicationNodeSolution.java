package com.dumas.pedestal.ms.algorithm.linklist;

/**
 * 删除重复结点
 * @author dumas
 * @date 2021/12/14 2:25 PM
 */
public class DeleteDuplicationNodeSolution {
    /**
     * 题目：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
     * 示例：
     *  输入：{1,2,3,3,4,4,5}返回值：{1,2,5}
     * 分析：
     *  NC24 删除有序链表中重复的元素II同题，注意是删除重复结点不保留
     */

    /**
     * 升序链表删除重复结点
     */
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = pHead;
        while(cur != null){
            // 没有后继||前后不一致，就加入pre后继
            if(cur.next == null || cur.val != cur.next.val){
                pre.next = cur;
                pre = cur;
            }
            // 否则，就一直后移cur，让cur指向相同节点的最后一个节点
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            // 本题不保留重复结点，这里不用pre.next = cur
            // 相同节点的最后一个结点不保留，后移cur
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
