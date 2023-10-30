package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    static boolean[] visited;

    public static void main(String[] args) {
        int N = sc.nextInt();
        visited = new boolean[N + 1];

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
        }

        int a = DFS(s, 0);
        int b = DFS(e, 0);
        System.out.println(a);
        System.out.println(b);
    }

    public static int DFS(int n, int count) {
        Integer next = list.get(n).get(0);
        if (!visited[next]) {
            visited[next] = true;
            return DFS(next, count + 1);
        }

        return -1;
    }
}
