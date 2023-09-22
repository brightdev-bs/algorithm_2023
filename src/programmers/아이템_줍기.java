package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {

    int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int n = rectangle.length;
        int m = rectangle[0].length;

        int[][] graph = new int[103][103];
        for(int[] curRec : rectangle) {
            for(int x = curRec[0] * 2; x <= curRec[2] * 2; x++) {
                for(int y = curRec[1] * 2; y <= curRec[3] * 2; y++) {
                    graph[x][y] = 1;
                }
            }
        }

        for(int[] curRec : rectangle) {
            for(int x = curRec[0] * 2 + 1; x < curRec[2] * 2; x++) {
                for(int y = curRec[1] * 2 + 1; y < curRec[3] * 2; y++) {
                    graph[x][y] = 0;
                }
            }
        }


        boolean[][] visited = new boolean[103][103];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX * 2, characterY * 2});
        visited[characterX * 2][characterY * 2] = true;
        int dept = 0;
        while(!queue.isEmpty()) {
            dept++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(x == itemX * 2 && y == itemY * 2) return dept / 2;
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;

    }
}
