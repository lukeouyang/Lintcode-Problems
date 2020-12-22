//609. Two Sum - Less than or equal to target
//        中文English
//        Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
//
//        样例
//        Example 1:
//
//        Input: nums = [2, 7, 11, 15], target = 24.
//        Output: 5.
//        Explanation:
//        2 + 7 < 24
//        2 + 11 < 24
//        2 + 15 < 24
//        7 + 11 < 24
//        7 + 15 < 24
//        Example 2:
//
//        Input: nums = [1], target = 1.
//        Output: 0.

        package array.problems;

import java.util.Arrays;

public class TwoSumLessThanTarget {
    public static int twoSum5(int[] nums, int target) {
        if(nums==null || nums.length <= 1) return 0;

        Arrays.sort(nums);

        int cnt = 0;
        int start = 0, end = nums.length-1;
        while (start < end) {
            if((nums[start] + nums[end]) <= target) {
                cnt += end - start;
                start++;
            }
            else {
                end--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        System.out.println(twoSum5(input, 24));
    }
}
