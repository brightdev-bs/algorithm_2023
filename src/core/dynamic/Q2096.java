package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2096 {

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


    public static void main(String[] args) {
        int N = sc.nextInt();
        int[][] board = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[][] sdy = new int[N + 1][4];
        int[][] bdy = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            bdy[i][1] = Math.max(bdy[i - 1][1], bdy[i - 1][2]) + board[i][1];
            bdy[i][2] = Math.max(Math.max(bdy[i - 1][1], bdy[i - 1][2]), bdy[i - 1][3]) + board[i][2];
            bdy[i][3] = Math.max(bdy[i - 1][2], bdy[i - 1][3]) + board[i][3];

            sdy[i][1] = Math.min(sdy[i - 1][1], sdy[i - 1][2]) + board[i][1];
            sdy[i][2] = Math.min(Math.min(sdy[i -1][1], sdy[i -1][2]), sdy[i - 1][3]) + board[i][2];
            sdy[i][3] = Math.min(sdy[i - 1][2], sdy[i - 1][3]) + board[i][3];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 3; i++) {
            min = Math.min(min, sdy[N][i]);
            max = Math.max(max, bdy[N][i]);
        }

        System.out.println(max + " " + min);
    }
}
