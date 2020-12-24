/*
31. Partition Array
中文English
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

样例
Example 1:

Input:
[],9
Output:
0

Example 2:

Input:
[3,2,2,1],2
Output:1
Explanation:
the real array is[1,2,2,3].So return 1
挑战
Can you partition the array in-place and in O(n)?

注意事项
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length
 */
package array.problems;

public class PartitionArray {
    public static int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            while(left<=right && nums[left] < k) {
                left++;
            }
            while(left<=right && nums[right] >= k) {
                right--;
            }
            if(left <= right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            }


        }
        return left;
    }

    public static void main(String[] args) {
        int[] inArray = {110,159,48,56,24,192,126,109,102,103,183,194,110,155,110,28,159,183,147,77,58,35,136,175,148,182,140,47,168,76,97,178,190,134,152,197,100,105,104,27,69,99,94,154,138,97,103,171,145,73,94,124,105,188,173,176,184,157,160,161,27,198,20,88,129,28,104,163,31,181,40,60,180,158,54,191,118,152,119,189,134,43,147,23,158,195,148,146,176,78,20,166,24,46,140,178,54,143,86,138,124,195,84,71,24,55,90,188,171,68,111,68,183,195,77,43,142,42,151,141,104,105,62,153,199,159,55,120,169,146,45,64,109,58,136,101,154,74,192,102,84,196,60,111,97,57,194,40,142,41,147,151,141,118,166,185,80,185,80,36,52,100,121,117,37,75,177,85,123,160,100,116,158,129,148,24,137,49,56,128};
        int target = 110;
        System.out.println(partitionArray(inArray,target));
    }
}
