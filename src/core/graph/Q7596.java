package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7596 {

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

    static int[] dr = { -1, 0, 0, 0, 0, 1}, dc = {0, -1, 1, 0, 0, 0}, dh = {0, 0, 0, 1, -1, 0};


    public static void main(String[] args) {
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[][][] graph = new int[N][M][H];
        List<int[]> ripenTomato = new ArrayList<>();
        int youngTomato = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int input = sc.nextInt();
                    graph[i][j][h] = input;
                    if (input == 1) ripenTomato.add(new int[]{i, j, h});
                    else if (input == 0) youngTomato++;
                }
            }
        }

        boolean[][][] visited = new boolean[N][M][H];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] tomato : ripenTomato) {
            int r = tomato[0];
            int c = tomato[1];
            int h = tomato[2];
            visited[r][c][h] = true;
            queue.add(new int[]{r, c, h});
        }

        int day = 0;
        while (!queue.isEmpty()) {
            if(youngTomato == 0) break;
            day++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int h = cur[2];
                for (int j = 0; j < 6; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    int nh = h + dh[j];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0
                            && nh < H && graph[nr][nc][nh] == 0
                            && !visited[nr][nc][nh]
                    ) {
                        queue.add(new int[]{nr, nc, nh});
                        visited[nr][nc][nh] = true;
                        youngTomato--;

                    }
                }
            }
        }

        if(youngTomato != 0) System.out.println(-1);
        else System.out.println(day);

    }
}
