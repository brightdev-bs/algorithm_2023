package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q4830 {

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

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int nodeCount = 0;
    static int edgeCount = 0;


    public static void main(String[] args) throws IOException {
        int TC = 1;
        while(true) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if(N == 0 && M == 0) break;
            graph = new ArrayList<>();
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            // ㅈㅓㅇ답 적기~

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    nodeCount = 0;
                    edgeCount = 0;
                    visited[i] = true;
                    DFS(i);
                    if (edgeCount == (nodeCount - 1) * 2) count++;
                }
            }

            //
            StringBuilder sb = new StringBuilder();

            sb.append("Case ").append(TC).append(": ");
            if (count == 0){
                sb.append("No trees.\n");
            } else if (count == 1){
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(count).append(" trees.\n");
            }

            System.out.println(sb);
            TC++;
        }

    }

    private static void DFS(int s) {
        nodeCount++;
        edgeCount += graph.get(s).size();
        for (Integer next : graph.get(s)) {
            if(visited[next]) continue;
            visited[next] = true;
            DFS(next);
        }
    }

}
