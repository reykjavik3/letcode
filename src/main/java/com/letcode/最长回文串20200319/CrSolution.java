package com.letcode.最长回文串20200319;

/**
 * @author licongrong
 * @create 2020-03-19 22:48
 **/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 打法：把相同字母放在一组，如果是多于两个的奇数，计算长度-1，如果是偶数，直接加进来
 * 看是否有单个的，奇数的相同字符也算，如果有再加一
 */
public class CrSolution {
    public static int longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if(integer==null){
                map.put(aChar,1);
            }else{
                map.put(aChar,++integer);
            }
        }
        boolean haveOdd = false;
        int length = 0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value==1){
                haveOdd=true;
                continue;
            }
            boolean even = value%2==0;
            if(even){
                length+=value;
            }else{
                length+=value-1;
                haveOdd=true;
            }

        }
        if(haveOdd){
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
