package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1949R {

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
    static int[] population;
    static int[][] dy;

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        int N = sc.nextInt(); // 마을 개수
        population = new int[N + 1];
        dy = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.get(s).add(e);
            list.get(e).add(s);
        }

        DFS(1, - 1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    // dy[i][0] // 선택 하지 않았을 때
    // dy[i][1] // 선택 했을 때
    public static void DFS(int r, int prev) {
        dy[r][1] += population[r];
        for (int next : list.get(r)) {
            if(next != prev) {
                DFS(next, r);
                dy[r][0] += Math.max(dy[next][0], dy[next][1]);
                dy[r][1] += dy[next][0];
            }
        }
    }
}
