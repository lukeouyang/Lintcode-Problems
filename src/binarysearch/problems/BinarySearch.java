//457. Classical Binary Search
//        中文English
//        Find any position of a target number in a sorted array. Return -1 if target does not exist.
//
//        样例
//        Example 1:
//
//        Input: nums = [1,2,2,4,5,5], target = 2
//        Output: 1 or 2
//        Example 2:
//
//        Input: nums = [1,2,2,4,5,5], target = 6
//        Output: -1
//        挑战
//        O(logn) time
package binarysearch.problems;

public class BinarySearch {
    public static int findPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length-1;

        while(start < end) {
            int mid = start + (end - start)/2;
            if(target == nums[mid]) return mid;
            if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(nums[start] == target) return start;

        return -1;
    }

    public static int findPosition2(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length-1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) return -1;

        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;

        if(nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        }
        return binarySearch(nums, start, mid - 1, target);
    }
}
