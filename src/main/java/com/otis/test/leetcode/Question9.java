package com.otis.test.leetcode;

/**
 * Question9
 */
public class Question9 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-121));
    }

    private static class Solution {
    
        boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            return String.valueOf(x).equals(String.valueOf(this.reverse(x)));
        }

        long reverse(int x) {
            long result = 0;
            while (x != 0) {
                result = result * 10 + x % 10;
                x  = x / 10;
            }

            return result;
        }
    }
}