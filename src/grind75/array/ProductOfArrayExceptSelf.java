package grind75.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // first
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
            sum *= nums[i];
        }

        int[] answer = new int[nums.length];

        if(zeroCount > 1) Arrays.fill(answer, 0);
        else if(zeroCount == 1) {
            sum = 1;
            for(int i = 0; i < nums.length; i++) {
                if(i != zeroIndex) sum *= nums[i];
            }
            answer[zeroIndex] = sum;
        } else {
            for(int i = 0; i < nums.length; i++) {
                answer[i] = sum / nums[i];
            }
        }

        return answer;
    }

    // second
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for(int left = 0, tmp = 1; left < n; left++) {
            answer[left] *= tmp;
            tmp *= nums[left];
        }

        for(int right = n - 1, tmp = 1; right >= 0; right--) {
            answer[right] *= tmp;
            tmp *= nums[right];
        }

        return answer;
    }
}
