package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {

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
    static int T, C, R,K;
    static int[][] graph;
    static int[] dc = { -1, 0, 0, 1}, dr = {0, -1, 1, 0};

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        T = sc.nextInt();
        while(T-- > 0) {
            C = sc.nextInt();
            R = sc.nextInt();
            K = sc.nextInt();

            graph = new int[R][C];

            for(int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[y][x] = 1;
            }

            int count = 0;
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(graph[i][j] == 1) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void DFS(int r, int c) {
        graph[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];
            if(nc >= 0 && nc < C && nr >= 0 && nr < R && graph[nr][nc] == 1) {
                DFS(nr, nc);
            }
        }
    }
}
