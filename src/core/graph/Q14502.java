package core.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14502 {

    static int n,m;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static List<int[]> jombie;
    static int[][] spaces;
    static int emptyCount = 0;
    static int[][] graph;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        spaces = new int[n * m + 1][2];

        jombie = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) jombie.add(new int[]{i, j});
            }
        }

        pro();
        DFS(0, 0);
        System.out.println(max);
    }

    public static void pro() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0) {
                    spaces[emptyCount][0] = i;
                    spaces[emptyCount][1] = j;
                    emptyCount++;
                }
            }
        }
    }

    public static void DFS(int index, int L) {
        if(L == 3) {
            bfs();
            return;
        }

        if(index >= emptyCount) return;

        graph[spaces[index][0]][spaces[index][1]] = 1;
        DFS(index + 1, L + 1);

        graph[spaces[index][0]][spaces[index][1]] = 0;
        DFS(index + 1, L);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(jombie);
        int[][] temp = copyOriginalGraph();
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int i = 0 ; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(temp[nr][nc] == 0) {
                        temp[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        max = Math.max(max, countSafePlace(temp));
    }

    private static int countSafePlace(int[][] graph) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int[][] copyOriginalGraph() {
        int[][] temp = new int[graph.length][];
        for(int i = 0; i < graph.length; i++) {
            temp[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        return temp;
    }
}
