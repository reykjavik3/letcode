package com.letcode.词汇表20200317;

import java.util.*;

/**
 * @author licongrong
 * @create 2020-03-17 09:00
 * 我的思路 维护一个Map<Character,Integer>,key是字符串的值，value是字符串的个数
 **/
//时间空间都不高
public class CrSolution {

    public static int countCharacters(String[] words, String chars) {
        if (words.length == 0 || chars.length() == 0 || words == null || chars == null) {
            return 0;
        }
        int length = 0;
        HashMap<Character, Integer> container = new HashMap<>();
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            Integer integer = container.get(c);
            if (integer == null) {
                container.put(c, 1);
            } else {
                container.put(c, ++integer);
            }
        }
        for (String word : words) {
            boolean needAdd = true;
            if (word.length() == 0 || word.trim().length() == 0) {
                continue;
            }
            char[] wordArray = word.toCharArray();
            HashMap<Character, Integer> cs = new HashMap<>();
            for (char c : wordArray) {
                Integer integer = cs.get(c);
                if (integer == null) {
                    cs.put(c, 1);
                } else {
                    cs.put(c, ++integer);
                }

            }
            Set<Map.Entry<Character, Integer>> entries = cs.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                Integer integer = container.get(entry.getKey());
                if (integer == null || integer < entry.getValue()) {
                    needAdd=false;
                    break;
                }
            }
            if(needAdd){
                length += word.length();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(countCharacters(words, chars));
    }

}
