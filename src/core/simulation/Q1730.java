package core.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Q1730 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String input = sc.hasNext() ? sc.next() : "";

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], '.');
        }
        int r = 0;
        int c = 0;

        boolean[][] vertical = new boolean[N][N];
        boolean[][] horizontal = new boolean[N][N];
        for (char current : input.toCharArray()) {
            if (current == 'U') {
                if (r - 1 < 0) continue;
                vertical[r][c] = true;
                vertical[r - 1][c] = true;
                r = r - 1;
            }

            if (current == 'D') {
                if (r + 1 >= N) continue;
                vertical[r][c] = true;
                vertical[r + 1][c] = true;
                r = r + 1;
            }

            if (current == 'L') {
                if (c - 1 < 0) continue;
                horizontal[r][c] = true;
                horizontal[r][c - 1] = true;
                c = c - 1;
            }

            if (current == 'R') {
                if (c + 1 >= N) continue;
                horizontal[r][c] = true;
                horizontal[r][c + 1] = true;
                c = c + 1;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i  <N; i++) {
            for (int j = 0; j  <N; j++) {
                if (horizontal[i][j] && vertical[i][j])
                    sb.append('+');
                else if (horizontal[i][j])
                    sb.append('-');
                else if (vertical[i][j])
                    sb.append('|');
                else
                    sb.append('.');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
