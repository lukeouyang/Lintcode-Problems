/*
159. Find Minimum in Rotated Sorted Array
中文English
Suppose a sorted array in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

样例
Example 1:

Input：[4, 5, 6, 7, 0, 1, 2]
Output：0
Explanation：
The minimum value in an array is 0.
Example 2:

Input：[2,1]
Output：1
Explanation：
The minimum value in an array is 1.
注意事项
You can assume no duplicate exists in the array.
 */
package array.problems;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) throws IllegalArgumentException{
        if(nums == null || nums.length == 0) throw new IllegalArgumentException();
        if(nums.length == 1) return nums[0];

        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(!greaterThanLeft(nums, mid) && lessThanRight(nums, mid)) return nums[mid];
            if(greaterThanLeft(nums, mid) && !lessThanRight(nums, mid)) return nums[mid+1];
            if(nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }

        }

        return Math.min(nums[start], nums[end]);
    }

    private boolean greaterThanLeft(int[] nums, int index){
        if(index == 0) return true;
        return nums[index] > nums[index-1];
    }
    private boolean lessThanRight(int[] nums, int index) {
        if(index == nums.length - 1) return true;
        return nums[index+1] > nums[index];
    }
}
