package com.dumas.pedestal.ms.algorithm.string;

/**
 * 表示数值的字符串
 * @author dumas
 * @date 2021/12/13 3:38 PM
 */
public class IsNumberSolution {
    /**
     * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
     * 数值（按顺序）可以分成以下几个部分：
     *    1若干空格
     *    2一个 小数 或者 整数
     *    3（可选）一个 'e' 或 'E' ，后面跟着一个 整数
     *    4若干空格
     * 小数（按顺序）可以分成以下几个部分：
     *    1可选）一个符号字符（'+' 或 '-'）
     *    2至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     *    3一个点 '.' ，后面跟着至少一位数字
     * 整数（按顺序）可以分成以下几个部分：
     *    1（可选）一个符号字符（'+' 或 '-'）
     *    2至少一位数字
     * 部分数值列举如下：
     *  ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
     * 部分非数值列举如下：
     *  ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
     * 示例 1：输入：s = "0"输出：true
     * 示例 2：输入：s = "e"输出：false
     * 示例 3：输入：s = "."输出：false
     * 示例 4：输入：s = "    .1  "输出：true
     * 提示：
     *      1 <= s.length <= 20s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
     * 分析：
     *  判断true情况太多，我们思考判断false情况，定义四种布尔值
     *  - hasNum，hasSign，hasE，hasDot
     *  遍历指针：index
     *  清除字符串前面空格，index++
     *  while(index<n)判断
     *      - 先判断数字部分，直到遇到非数字 or 直接到达字符串末尾，返回ture
     *      - 再判断非数字部分
     *          - 判断E：如果之前有E or 之前无数字，返回false；否则hasE=true，其余三个重置false
     *          - 判断+，-：如果之前有+，- or 有数字 or 有.，返回false；否则hasSign=true
     *          - 判断.：如果之前有. or 有E，返回false；否则hasDot=true
     *          - 遇到空格，直接结束循环，因为此时index不可能再等于n，结果也为false
     *       - index++
     *  清除字符串后面空格，index++
     *  返回： hasNum && index == n
     */
    public static boolean isNumber(String s){
        int n = s.length();
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;
        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        while(index < n){
            while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                hasNum = true;
                index++;
            }
            if(index == n){
                break;
            }
            if(s.charAt(index) == 'E' || s.charAt(index) == 'e'){
                if(hasE || !hasNum){
                    return false;
                }
                hasE = true;

                hasNum = false;
                hasDot = false;
                hasSign = false;
            }else if(s.charAt(index) == '+' || s.charAt(index) == '-'){
                if(hasSign || hasNum || hasDot){
                    return false;
                }
                hasSign = true;
            }else if(s.charAt(index) == '.'){
                if(hasDot || hasE){
                    return false;
                }
                hasDot = true;
            }else if(s.charAt(index) == ' '){
                break;
            }else{
                return false;
            }
            index++;
        }
        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        return hasNum && index == n;
    }

    public static void main(String[] args) {

    }
}
