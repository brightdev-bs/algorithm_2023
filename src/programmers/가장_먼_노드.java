package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {
    class Solution {
        public int solution(int n, int[][] edge) {

            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for(int[] node : edge) {
                int a = node[0];
                int b = node[1];
                list.get(a).add(b);
                list.get(b).add(a);
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] visited = new int[n + 1];
            visited[1] = -1;
            for(Integer cur : list.get(1)) {
                visited[cur] = 1;
                queue.add(cur);
            }

            int dept = 1;
            while(!queue.isEmpty()) {
                dept++;
                int len = queue.size();
                for(int i = 0; i < len; i++) {
                    int cur = queue.poll();
                    for(Integer next : list.get(cur)) {
                        if(visited[next] == 0) {
                            visited[next] = dept;
                            queue.add(next);
                        }
                    }
                }
            }

            int answer = 0;
            for(int i = 1; i <= n; i++) {
                if(visited[i] == dept - 1) answer++;
            }

            return answer;
        }
    }
}
