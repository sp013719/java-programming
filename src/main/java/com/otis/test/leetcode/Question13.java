package com.otis.test.leetcode;

import java.util.HashMap;

/**
 * Question13
 */
public class Question13 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("IX"));
    }

    static class Solution {

        private static HashMap<Character, Integer> map = new HashMap<>();

        static {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }
    
        public int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int currentNum = map.get(currentChar);

                if (i == s.length() - 1) {
                    return result + currentNum;
                } 
                
                char nextChar = s.charAt(i + 1);
                int nextNum = map.get(nextChar);

                if (currentNum < nextNum) {
                    result = result - currentNum;
                } else {
                    result = result + currentNum;
                }
            }

            return result;
        }
    }
}