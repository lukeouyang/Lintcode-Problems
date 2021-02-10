package array.problems;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0, j= 0;
        int sum = 0;
        int minL = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        sum = nums[0];
        while(i <= j && j < n) {
            System.out.println(i + " " + j);
            if(sum >= target) {
                if(j - i + 1 < minL)
                    minL = j - i + 1;
                sum -= nums[i];
                i++;
            } else {
                j++;
                if(j < n) {
                    sum += nums[j];
                } else break;

            }

        }
        if(minL > 0) return minL;
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        System.out.println(msss.minSubArrayLen(target, nums));
    }
}
