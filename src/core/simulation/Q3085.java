package core.simulation;

import java.util.Scanner;

public class Q3085 {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swap(map, i, j, i, j + 1);
                    answer = Math.max(answer, Math.max(findMaxRow(map), findMaxCol(map)));
                    swap(map, i, j, i, j + 1);
                }

                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swap(map, i, j, i + 1, j);
                    answer = Math.max(answer, Math.max(findMaxRow(map), findMaxCol(map)));
                    swap(map, i, j, i + 1, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void swap(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    private static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int len = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) len++;
                else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }

        return maxRow;
    }

    private static int findMaxCol(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) len++;
                else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }

        return maxColumn;
    }

}

