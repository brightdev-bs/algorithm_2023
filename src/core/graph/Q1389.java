package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1389 {

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

    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int dis = findMinimumDisatance(i);
            if(dis < min) {
                min = dis;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    public static int findMinimumDisatance(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                for (Integer next : list.get(cur)) {
                    if(dist[next] > dist[cur] + 1) {
                        dist[next] = dist[cur] + 1;
                        queue.add(next);
                    }
                }
            }
        }

        int sum = 0;
        for (int i : dist) {
//            System.out.print(i + " ");
            sum += i;
        }
        return sum;
    }
}
