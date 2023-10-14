package core.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3055 {
    static int r, c;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        char[][] map;
        map = new char[r][c];
        for(int i = 0; i < r; i++) {
            String input = sc.nextLine();
            map[i] = input.toCharArray();
        }

        int[] des = new int[2];
        Queue<int[]> sPath = new LinkedList<>();
        Queue<int[]> wPath = new LinkedList<>();
        // 물과 고슴도치 위치 체크
        Arrays.fill(des, -1);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'S') sPath.add(new int[]{i, j});
                else if(map[i][j] == '*') wPath.add(new int[]{i, j});
                else if(map[i][j] == 'D') des = new int[]{i, j};
            }
        }

        int count = 0;
        while(!sPath.isEmpty()) {
            count++;
            int wLen = wPath.size();
            for(int i = 0; i < wLen; i++) {
                int[] current = wPath.poll();
                for(int j = 0; j < 4; j++) {
                    int nr = current[0] + dr[j];
                    int nc = current[1] + dc[j];
                    if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
                        if(map[nr][nc] == '.') {
                            map[nr][nc] = '*';
                            wPath.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            int sLen = sPath.size();
            for(int i = 0; i < sLen; i++) {
                int[] current = sPath.poll();
                for(int j = 0; j < 4; j++) {
                    int nr = current[0] + dr[j];
                    int nc = current[1] + dc[j];
                    if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
                        if(nr == des[0] && nc == des[1]) {
                            System.out.println(count);
                            System.exit(0);
                        }
                        if(map[nr][nc] == '.') {
                            map[nr][nc] = 'X';
                            sPath.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }

}
