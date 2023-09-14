package grind75.review;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int answer = nums[0];
        int sum = 0;
        for(int n : nums) {
            sum = Math.max(sum + n, n);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
