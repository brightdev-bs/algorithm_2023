package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {

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
    static int N;
    static int[][] graph;

    public static void main(String[] args) {
        N = sc.nextInt();
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[][] answer = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            boolean[] check = new boolean[N + 1];
            // 이것 때문에 한참 걸림
//            check[i] = true;
            for (int j = 1; j <= N; j++) {
                if(graph[i][j] == 1) {
                    DFS(i, check);
                }
            }

            for(int k = 1; k <= N; k++) {
                if(check[k]) answer[i][k] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void DFS(int r, boolean[] check) {
        for(int i = 1; i <= N; i++) {
            if(!check[i] && graph[r][i] == 1) {
                check[i] = true;
                DFS(i, check);
            }
        }

    }
}
