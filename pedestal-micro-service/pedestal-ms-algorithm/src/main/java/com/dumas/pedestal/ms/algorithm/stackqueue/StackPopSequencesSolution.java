package com.dumas.pedestal.ms.algorithm.stackqueue;

/**
 * 栈的压入弹出序列
 * @author dumas
 * @date 2021/12/15 3:28 PM
 */
public class StackPopSequencesSolution {
    /**
     * 题目:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
     * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
     * 示例 1：
     *  输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]输出：true
     *  解释：我们可以按以下顺序执行：push(1), push(2), push(3), push(4), pop() -> 4,push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * 示例 2：
     *  输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]输出：false解释：1 不能在 2 之前弹出。
     * 提示：
     *  0 <= pushed.length == popped.length <= 10000 <= pushed[i], popped[i] < 1000pushed 是 popped 的排列。
     * 分析：
     *  使用一个栈模拟push和pop过程
     *  遍历pushed数组，往栈中加入元素，直到栈顶元素和poped[i]数组元素相同就停止
     *      遇到相同，就出栈直到不同，所以内层是while循环，不是if判断
     *  返回值：模拟栈是否为空，为空就代表true匹配成功
     */
    public boolean validateStackSequence(int[] pushed, int[] popped){
        int[] stack = new int[pushed.length];
        int stackIndex = 0, popAIndex = 0;
        for(int numA:pushed){
            stack[stackIndex++] = numA;
            while(stackIndex != 0 && stack[stackIndex - 1] == popped[popAIndex]){
                stackIndex--;
                popAIndex++;
            }
        }
        return stackIndex == 0;
    }

    /**
     * 牛客JZ21
     */
    public Boolean IsPopOrder(int[] pushA, int[] popA){
        int[] stack = new int[pushA.length];
        int stackIndex = 0, popAIndex = 0;
        for(int numA : pushA){
            stack[stackIndex++] = numA;
            while(stackIndex != 0 && stack[stackIndex - 1] == popA[popAIndex]){
                stackIndex--;
                popAIndex++;
            }
        }
        return stackIndex == 0;
    }
}
