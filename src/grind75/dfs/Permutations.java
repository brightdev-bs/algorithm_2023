package grind75.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    int[] ch;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        ch = new int[nums.length];
        DFS(answer, new ArrayList<>(), nums);
        return answer;
    }

    public void DFS(List<List<Integer>> answer, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    temp.add(nums[i]);
                    DFS(answer, temp, nums);
                    temp.remove(temp.size() - 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
