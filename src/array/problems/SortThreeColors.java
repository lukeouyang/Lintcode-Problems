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
