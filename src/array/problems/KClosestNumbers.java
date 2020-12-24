/*
460. Find K Closest Elements
中文English
Given target, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

样例
Example 1:

Input: A = [1, 2, 3], target = 2, k = 3
Output: [2, 1, 3]
Example 2:

Input: A = [1, 4, 6, 8], target = 3, k = 3
Output: [4, 1, 6]
挑战
O(logn + k) time

注意事项
The value k is a non-negative integer and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 10^4
Absolute value of elements in the array will not exceed 10^4
 */
package array.problems;

import java.util.Arrays;

public class KClosestNumbers {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        //if(A == null || A.length == 0) return -1;
        // first use binary search to find the element closestly strictly smaller than target
        int left = findClosestSmaller(A, target);
//        System.out.println(left);
        int right = left + 1;
        //than step one pos right, compare left ele and right ele to determine which one is
        //closer to the target, add to the result
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            if(isLeftCloser(A, left, right, target)) {
                result[i] = A[left--];
            } else {
                result[i] = A[right++];
            }
        }
        return result;
    }

    private int findClosestSmaller(int[] A, int target) {
        int start = 0, end = A.length -1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(A[end] < target) return end;
        if(A[start] < target) return start;
        return -1;
    }

    private boolean isLeftCloser(int[] A, int left, int right, int target) {
        if(left < 0) return false;
        if(right >= A.length) return true;

        if((target - A[left]) != (A[right] - target))
            return (target - A[left]) < (A[right] - target);

        return true;
    }

    public static void main(String[] args) {
        KClosestNumbers kClosestNumbers = new KClosestNumbers();
        int[] input = {1,4,6,8};  //[4,1,6]
        int target = 3;
        int k = 3;
        System.out.println(Arrays.toString(kClosestNumbers.kClosestNumbers(input,target,k)));
    }
}
