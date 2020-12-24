/*
148. Sort Colors
中文English
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

样例
Example 1

Input : [1, 0, 1, 2]
Output : [0, 1, 1, 2]
Explanation : sort it in-place
挑战
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

注意事项
You are not suppose to use the library's sort function for this problem.
You should do it in-place (sort numbers in the original array).
 */
package array.problems;

import java.util.Arrays;

public class SortThreeColors {
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <=1) return;

        int head = 0;
        int tail = nums.length - 1;
        int i = 0;
        while (i <= tail) {
            if (nums[i] == 0) {
                swap(nums, head++, i++);
            }
            else if (nums[i] == 2) {
                swap(nums, i, tail--);
            }
            else {
                i++;
            }
        }
    }


    private static void swap(int[] nums, int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public static void main(String[] args) {
        int[] input = {2,0,0,1,2,0,2};
        System.out.println(Arrays.toString(input));
        sortColors(input);
        System.out.println(Arrays.toString(input));

    }
}
