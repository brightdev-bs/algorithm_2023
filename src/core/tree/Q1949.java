package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1949 {

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

    static int[][] dy;
    static List<ArrayList<Integer>> list;
    static int[] population;

    public static void main(String[] args) {
        int N = sc.nextInt();

        dy = new int[N + 1][2];
        population = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
        }

        list = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(1, 0);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    private static void DFS(int R, int prev) {
        dy[R][0] = 0;
        dy[R][1] = population[R];
        for (Integer next : list.get(R)) {
            if(next != prev) {
                DFS(next, R);
                dy[R][0] += Math.max(dy[next][0], dy[next][1]);
                dy[R][1] += dy[next][0];
            }
        }
    }
}
