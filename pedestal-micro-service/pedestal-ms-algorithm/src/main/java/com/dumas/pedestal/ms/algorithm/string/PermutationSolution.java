package com.dumas.pedestal.ms.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串的排列
 * @author dumas
 * @date 2021/12/13 4:58 PM
 */
public class PermutationSolution {

    /**
     * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 示例:
     *  输入：s = "abc"输出：["abc","acb","bac","bca","cab","cba"]
     * 分析：
     *  当字符串存在重复字符时，排列方案中也存在重复的排列方案。为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次"=剪枝
     *  定义一个递归函数dfs ，剪枝+回溯模版如下
     *  private void dfs(int pos) {
     *       // base case：固定位置来到最后一个字符
     *       if (pos == cs.length - 1) {
     *           res.add(String.valueOf(cs));
     *           return;
     *       }
     *       // ...
     *       // 从固定位置pos往后开始递归其他分支
     *       for (int i = pos; i < cs.length; i++) {
     *           // 判断去重，剪枝
     *           // 交换,将cs[i]固定在pos位置
     *           swap(i, pos);
     *           // 递归固定后续index+1的位置
     *           dfs(pos + 1);
     *           // 回溯：交换回原数组顺序
     *           swap(i, pos);
     *       }
     *   }
     *   Over
     */

    private char[] cs;
    private List<String> res;

    /**
     * 剑指38 字符串的排列
     */
    public String[] permutation(String s){
        if(s == null || s.length() == 0){
            return new String[]{};
        }
        res = new ArrayList<>();
        cs = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int pos){
        if(pos == cs.length - 1){
            res.add(String.valueOf(cs));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < cs.length; i++){
            if(set.contains(cs[i])){
                continue;
            }
            set.add(cs[i]);
            // 交换,将cs[i]固定在pos位置
            swap(i, pos);
            // 递归固定后续index+1的位置
            dfs(pos + 1);
            // 回溯：交换回原数组顺序
            swap(i, pos);
        }
    }

    private void swap(int a, int b){
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }

    /***********************************************************************************************/

    private ArrayList<String> resN;

    /**
     * 牛客JZ27
     */
    public ArrayList<String> permutationN(String s){
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        resN = new ArrayList<>();
        cs = s.toCharArray();
        dfsN(0);
        return resN;
    }

    private void dfsN(int pos){
        if(pos == cs.length - 1){
            resN.add(new String(cs));
            return;
        }
        ArrayList<Character> set = new ArrayList<>();
        for(int i = 0; i < cs.length; i++){
            if(set.contains(cs[i])){
                continue;
            }
            set.add(cs[i]);
            swap(cs, i, pos);
            dfs(pos + 1);
            swap(cs, i, pos);
        }
    }

    private void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        PermutationSolution solution = new PermutationSolution();
        String s = "aab";
        System.out.println(Arrays.toString(solution.permutation(s)));
    }
}
