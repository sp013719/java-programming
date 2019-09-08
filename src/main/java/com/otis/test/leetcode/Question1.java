package com.otis.test.leetcode;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Question1 {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int result[] = twoSum(new int[] {2, 7, 11, 15}, 17);

        if (result == null) {
            System.out.println("Can't found");
        } else {
            System.out.println(Arrays.toString(result));
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }
        }
        return null;
    }
}
