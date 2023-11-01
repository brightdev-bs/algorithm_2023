package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2644 {

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

    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) {
        int N = sc.nextInt();
        visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        int s = sc.nextInt();
        int e = sc.nextInt();

        int  m = sc.nextInt();
        for(int i = 0;  i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(y).add(x);
            list.get(x).add(y);
        }

        visited[s] = 0;
        DFS(s, 0);

        if(visited[e] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(visited[s] + visited[e]);
    }

    public static void DFS(int n, int count) {
        for (Integer next : list.get(n)) {
            if(visited[next] == Integer.MAX_VALUE) {
                visited[next] = count + 1;
                DFS(next, count + 1);
            }
        }
    }
}
