package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5567 {

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

        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i <= N; i++) friends.add(new ArrayList<>());

        for (int i = 1; i <= M; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            friends.get(f).add(t);
            friends.get(t).add(f);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int dept = 0;
        int count = 0;
        while (!queue.isEmpty() && dept < 2) {
            dept++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                for (Integer next : friends.get(cur)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        count++;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(count);
    }
}
