package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {

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

    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        int TC = sc.nextInt();

        while(TC-- > 0) {
            int I = sc.nextInt();
            graph = new int[I][I];
            visited = new boolean[I][I];

            int cr = sc.nextInt();
            int cc = sc.nextInt();

            int ar = sc.nextInt();
            int ac = sc.nextInt();

            if(cr == ar && cc == ac) {
                System.out.println(0);
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{cr, cc});
            visited[cr][cc] = true;
            int dept = 0;
            boolean find = false;
            while (!queue.isEmpty()) {
                if (find) break;
                dept++;
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    int[] cur = queue.poll();
                    int r = cur[0];
                    int c = cur[1];
                    for (int j = 0; j < 8; j++) {
                        int nr = r + dr[j];
                        int nc = c + dc[j];
                        if (nr >= 0 && nr < I && nc >= 0 && nc < I && !visited[nr][nc]) {
                            if (nr == ar && nc == ac) {
                                System.out.println(dept);
                                find = true;
                            }
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }


    }
}
