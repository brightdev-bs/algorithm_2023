package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q15681 {


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
    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] dy;
    public static void main(String[] args) {
       int N = sc.nextInt();
       int R = sc.nextInt();
       int Q = sc.nextInt();

        dy = new int[N + 1];
       visited = new boolean[N + 1];
       list = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

       for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
       }

       int[] questions = new int[Q];
       for (int i = 0; i < Q; i++) {
           questions[i] = sc.nextInt();
       }

       DFS(R, 0);

        for (int i = 0; i < Q; i++) {
            System.out.println(dy[questions[i]]);
        }
    }

    private static void DFS(int R, int prev) {
        dy[R] = 1;
        for (int child : list.get(R)) {
            if (child == prev) continue;
            DFS(child, R);
            dy[R] += dy[child];
        }
    }
}
