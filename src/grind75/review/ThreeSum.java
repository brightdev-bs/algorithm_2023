package grind75.review;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    set.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0) left++;
                else right--;
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);

        return list;
    }
}
