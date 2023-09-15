package grind75.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        DFS(answer, new ArrayList<>(), candidates, target, 0, 0);

        return answer;
    }

    public void DFS(List<List<Integer>> answer, List<Integer> temp, int[] arr, int target, int start, int sum) {
        if(sum > target) return;
        else if(sum == target) answer.add(new ArrayList<>(temp));
        else {
            for(int i = start; i < arr.length; i++) {
                temp.add(arr[i]);
                DFS(answer, temp, arr, target, i, sum + arr[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
