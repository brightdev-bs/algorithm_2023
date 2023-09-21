package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    class Solution {
        List<String> answer = new ArrayList<>();
        public String[] solution(String[][] tickets) {

            boolean[] visited = new boolean[tickets.length];
            DFS(tickets, visited, "ICN", "ICN", 0);

            Collections.sort(answer);
            return answer.get(0).split(",");
        }

        public void DFS(String[][] tickets, boolean[] visited, String cur, String path, int len) {
            if(len == tickets.length) {
                answer.add(path);
            } else {
                for(int i = 0; i < tickets.length; i++) {
                    String[] ticket = tickets[i];
                    String next = ticket[1];
                    if(!visited[i] && ticket[0].equals(cur)) {
                        visited[i] = true;
                        DFS(tickets, visited, next, path + "," + next, len + 1);
                        visited[i] = false;
                    }
                }
            }
        }

    }
}
