package com.dumas.pedestal.ms.algorithm.other;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 滑动窗口
 * @author dumas
 * @date 2021/12/22 2:55 PM
 */
public class SlidingWindowSolution {
    /**
     * 题目：无重复字符的最长字串
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，
     * 这时候不满足要求。所以，我们要移动这个队列！
     * 如何移动？
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     * 时间复杂度：O(n)O(n)
     */

    // 无重复字符的最长字串
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int start = 0, end = 0; end < s.length(); end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start = Math.max(start, map.get(alpha) + 1);
            }
            map.put(alpha, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    // 字符串的排列
    public boolean checkInclusion(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if(n > m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < n; ++i){
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1, cnt2)){
            return true;
        }
        for(int i = n; i <m; ++i){
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if(Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcabccbb";
        SlidingWindowSolution solution = new SlidingWindowSolution();
        System.out.println("无重复字符的最长字串：" + solution.lengthOfLongestSubstring(str));
    }
}
