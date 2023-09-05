package grind75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class OneMatrix {

    static int[] dr = { -1, 0, 0, 1}, dc = {0, 1, -1, 0};

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = mat.length * mat[0].length;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] > mat[r][c] + 1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }



        return mat;
    }
}
