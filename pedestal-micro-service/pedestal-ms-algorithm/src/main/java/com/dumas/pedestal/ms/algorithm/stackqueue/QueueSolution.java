package com.dumas.pedestal.ms.algorithm.stackqueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 两个栈实现队列
 * @author dumas
 * @date 2021/12/15 11:10 AM
 */
public class QueueSolution {
    /**
     * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *  示例 1：
     *      输入：["CQueue","appendTail","deleteHead","deleteHead"][[],[3],[],[]]输出：[null,null,3,-1]
     *  示例 2：
     *      输入：["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"][[],[],[5],[2],[],[]]输出：[null,-1,null,null,5,2]
     *  提示：
     *      1 <= values <= 10000最多会对 appendTail、deleteHead 进行 10000 次调用
     *  分析：
     *      定义一个push栈向pop栈压入的步骤（摊还时间复杂度），满足两个原则
     *          pop栈为空，必须向pop栈压入足够多的数据
     *          一旦要向pop栈压入数据，当时push栈里面的数据必须全部压入
     */

    /**
     * 剑指09 两个栈实现队列
     */

    private LinkedList<Integer> pushStack;
    private LinkedList<Integer> popStack;

    public QueueSolution(){
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    // 入队
    public void appednTail(int value){
        pushStack.push(value);
        pushToPop(pushStack, popStack);
    }

    // 出队
    public int deleteHead(){
        if(popStack.isEmpty() && pushStack.isEmpty()){
            return -1;
        }
        pushToPop(pushStack, popStack);
        return popStack.pop();
    }

    private void pushToPop(LinkedList<Integer> pushStack, LinkedList<Integer> popStack){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
}

/**
 * 牛客JZ5
 */
class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        push2Pop();
        stack1.push(node);
        push2Pop();
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        push2Pop();
        int pop = stack2.pop();
        push2Pop();
        return pop;
    }

    private void push2Pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
