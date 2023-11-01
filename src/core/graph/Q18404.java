package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18404 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static FastReader sc = new FastReader();

    static final int NUM_OF_MOVEMENT = 8;
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2}, dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] graph;
    static int[][] dist;

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int kr = sc.nextInt();
        int kc = sc.nextInt();

        List<int[]> targets = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            targets.add(new int[]{r, c});
            graph[r][c] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{kr, kc});
        dist[kr][kc] = 0;
        int dept = 0;
        while(!queue.isEmpty()) {
            dept++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for(int j = 0; j < NUM_OF_MOVEMENT; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if(nr >= 1 && nr <= N && nc >= 1 && nc <= N && dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dept;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int[] target : targets) {
            System.out.print(dist[target[0]][target[1]] + " ");
        }

    }
}
