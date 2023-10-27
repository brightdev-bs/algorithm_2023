package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3184 {

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
    static int R, C, sheep = 0, wolf = 0;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    static char[][] graph;

    public static void main(String[] args) {
        R = sc.nextInt();
        C = sc.nextInt();
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String next = sc.next();
            graph[i] = next.toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] != '#') {
                    BFS(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void BFS(int r, int c) {
        int sheepCount = 0;
        int wolfCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        if(graph[r][c] == 'o') sheepCount++;
        if(graph[r][c] == 'v') wolfCount++;

        graph[r][c] = '#';
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if(graph[nr][nc] == '#') continue;
                    if (graph[nr][nc] == '.') {}
                    else if (graph[nr][nc] == 'o') {
                        sheepCount++;
                    } else if (graph[nr][nc] == 'v') {
                        wolfCount++;
                    }
                    queue.add(new int[]{nr, nc});
                    graph[nr][nc] = '#';
                }
            }
        }

        if(sheepCount > wolfCount) sheep += sheepCount;
        else wolf += wolfCount;
    }
}
//
//###
//#v#
//###