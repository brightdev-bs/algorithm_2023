package core.graph;

import core.binarsearch.Q2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11724 {

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

    static int N,M;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void DFS(int s) {
        for (Integer next : graph.get(s)) {
            if(!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}
