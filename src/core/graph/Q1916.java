package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1916 {

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


    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<int[]>> graphs = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<int[]>())
                .collect(Collectors.toList());
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graphs.get(a).add(new int[]{b, c});
        }

        int S = sc.nextInt();
        int E = sc.nextInt();

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{S, 0});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int nowCost = current[1];
            if(nowCost > dist[now]) continue;

            for (int[] next : graphs.get(now)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if(dist[nextNode] > nextCost + nowCost) {
                    dist[nextNode] = nextCost + nowCost;
                    queue.add(new int[]{nextNode, nextCost + nowCost});
                }
            }

        }


        System.out.println(dist[E]);
    }
}
