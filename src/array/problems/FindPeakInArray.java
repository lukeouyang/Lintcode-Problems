/*
75. Find Peak Element
中文English
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

样例
Example 1:
	Input:  [1, 2, 1, 3, 4, 5, 7, 6]
	Output:  1 or 6

	Explanation:
	return the index of peek.


Example 2:
	Input: [1,2,3,4,1]
	Output:  3

挑战
Time complexity O(logN)

注意事项
It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.
 */
package array.problems;

import java.util.Arrays;

public class FindPeakInArray {
    public int findPeak(int[] nums) {
        int start = 1, end = nums.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
            if(nums[mid] < nums[mid-1]) {
                end = mid;
            } else if(nums[mid] < nums[mid+1]) {
                start = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
//public int findPeak(int[] A) {
//    // write your code here
//    int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
//    while(start + 1 <  end) {
//        int mid = (start + end) / 2;
//        if(A[mid] < A[mid - 1]) {
//            end = mid;
//        } else if(A[mid] < A[mid + 1]) {
//            start = mid;
//        } else {
//            end = mid;
//        }
//    }
//    if(A[start] < A[end]) {
//        return end;
//    } else {
//        return start;
//    }
//}

    public static void main(String[] args) {
        int[] input = {1,2,1,2,3,1};
        FindPeakInArray fpia = new FindPeakInArray();
        int index = fpia.findPeak(input);
        System.out.println("index: "+index + " array: "+ Arrays.toString(input));
    }
}
