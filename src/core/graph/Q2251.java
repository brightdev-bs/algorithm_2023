package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2251 {

    static class State {
        int[] _X = new int[3];

        public State(int[] _X) {
            for(int i = 0; i < 3; i++) {

            }
        }
    }

    static boolean[][][] visited = new boolean[201][201][201];
    static boolean[] answer = new boolean[201];
    static int[] limit = new int[3];

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0, limit[2]);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 200; i++) {
            if(answer[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void move(int from, int to, int[] current, int[] limit) {
        if(current[from] + current[to] <= limit[to]) {
            current[to] += current[from];
            current[from] = 0;
        } else {
            current[from] -= limit[to] - current[to];
            current[to] = limit[to];
        }
    }

    public static void bfs(int x1, int x2, int x3) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, x3});
        visited[x1][x2][x3] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(current[0] == 0) answer[current[2]] = true;
            for(int from = 0; from < 3; from++) {
                for(int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    move(from, to, current, limit);    // current가 공유가 되기 때문에 from, to가 바뀐 이후 값으로 move가 진행됨.

                    if(!visited[current[0]][current[1]][current[2]]) {
                        visited[current[0]][current[1]][current[2]] = true;
                        queue.add(new int[]{current[0], current[1], current[2]});
                    }
                }
            }
        }
    }
}
