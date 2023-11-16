package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1197 {

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

    // 최소 스패닝 트리 -> 프림, 크루스칼

    static int[] ch;

    public static void main(String[] args) {
        int V = sc.nextInt();
        int E = sc.nextInt();

        ch = new int[V + 1];
        for (int i = 0; i <= V; i++) ch[i] = i;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new int[]{a, b, c});
        }

        Collections.sort(list, (a, b) -> a[2] - b[2]);
        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] info = list.get(i);
            int a = info[0];
            int b = info[1];
            if(find(a) != find(b)) {
                union(a, b);
                answer += info[2];
            }
        }

        System.out.println(answer);

    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) ch[fb] = fa;
    }

    private static int find(int a) {
        if(ch[a] == a) return a;
        else return ch[a] = find(ch[a]);
    }

    public void prim() {
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> list = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) list.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{1, 0});
        long answer = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int nowCost = current[1];

            if(visited[now]) continue;

            visited[now] = true;
            answer += nowCost;

            for (int[] next : list.get(now)) {
                int nextNode = next[0];
                int nextCost = next[1];
                queue.add(new int[] {nextNode, nextCost});
            }

        }
        System.out.println(answer);
    }
}
