/*
587. Two Sum - Unique pairs
中文English
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

样例
Example 1:

Input: nums = [1,1,2,45,46,46], target = 47
Output: 2
Explanation:

1 + 46 = 47
2 + 45 = 47

Example 2:

Input: nums = [1,1], target = 2
Output: 1
Explanation:
1 + 1 = 2
 */

package array.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSumNumberOfParis {
    public int twoSum6(int[] nums, int target) {
        if(nums == null || nums.length < 2) return 0;

        Map<Integer, Integer> dict = new HashMap<>();

        //construct the dictionary of numbers with the counter of their appearance
        for(int n : nums) {
            if(dict.containsKey(n)) {
                dict.put(n, dict.get(n)+1);
            } else {
                dict.put(n, 1);
            }
        }

        int numOfPairs = 0;
        for(Integer k : dict.keySet()) {
            int comp = target - k;
            if(comp * 2 == target) {
                if(dict.get(comp) > 1) {
                    // I made a mistake here, has to be +2 not dict.get(comp), to count for each
                    // unique pair, unique pair unique pair 
                    numOfPairs+=2;
                }
            } else {
                if(dict.containsKey(comp)) numOfPairs++;
            }
        }

        return numOfPairs/2;

    }
}
