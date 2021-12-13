package com.dumas.pedestal.ms.algorithm.string;

/**
 * 替换空格
 * @author dumas
 * @date 2021/12/13 3:20 PM
 */
public class ReplaceSpaceSolution {
    /**
     * 题目:请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     * 示例 1：
     *  输入：s = "We are happy."输出："We%20are%20happy."
     *  分析：
     *      因为要改变字符串,单线程使用StringBuilder来append() 方便
     *      字符串定位字符：s.charAt(i)
     */

    /**
     * 剑指05 替换空格
     */
    public static String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    /**
     * 牛客JZ02
     */
    public static String replaceSpaceN(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String replace = s.replace(" ", "%20");
        System.out.println("剑指05 替换空格:" + replaceSpace(s));
    }
}
