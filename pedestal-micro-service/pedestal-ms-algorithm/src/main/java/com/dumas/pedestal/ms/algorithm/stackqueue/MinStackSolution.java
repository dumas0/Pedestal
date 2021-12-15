package com.dumas.pedestal.ms.algorithm.stackqueue;

import java.util.LinkedList;

/**
 * 包含min功能的栈
 * @author dumas
 * @date 2021/12/15 11:31 AM
 */
public class MinStackSolution {
    /**
     * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * 示例:
     *  MinStack minStack = new MinStack();
     *  minStack.push(-2);
     *  minStack.push(0);
     *  minStack.push(-3);
     *  minStack.min();   --> 返回 -3.
     *  minStack.pop();
     *  minStack.top();      --> 返回 0.
     *  minStack.min();   --> 返回 -2.
     * 提示：各函数的调用总次数不超过 20000 次
     * 分析：
     *  准备两个栈：dataStack记录数据，minStack记录最小值
     *  push：这里的push为非同步入栈，数据栈和最小值栈元素不用保持同一水平线，这样书写代码量最小
     *      数据栈每次都加入数据，最小值栈只有栈顶元数>待加入的值 or 最小值栈为空才入栈
     *  pop：记录出栈元素，如果和最小值栈顶元素相同，最小值栈顶也出栈
     *  top、min()正常判空，然后操作即可
     */
    private LinkedList<Integer> minStack;
    private LinkedList<Integer> dataStack;

    public void MinStack(){
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x){
        if(dataStack.isEmpty() || x <= dataStack.peek()){
            dataStack.push(x);
        }
        minStack.push(x);
    }

    public void pop(){
        if(minStack.isEmpty()){
            throw new RuntimeException("MinStack is null,not pop()");
        }
        int pop = minStack.pop();
        if(pop == min()){
            dataStack.pop();
        }
    }

    public int top(){
        if(minStack.isEmpty()){
            throw new RuntimeException("MinStack is null,not top()");
        }
        return minStack.peek();
    }

    public int min(){
        if(dataStack.isEmpty()){
            throw new RuntimeException("MinStack is null,not min()");
        }
        return dataStack.peek();
    }
}
