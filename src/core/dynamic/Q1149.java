package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1149 {

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

        int[][] houses = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                houses[i][j] = sc.nextInt();
            }
        }


        int[][] dy = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            dy[i][1] = Math.min(dy[i - 1][2], dy[i - 1][3]) + houses[i][1];
            dy[i][2] = Math.min(dy[i - 1][1], dy[i - 1][3]) + houses[i][2];
            dy[i][3] = Math.min(dy[i - 1][1], dy[i - 1][2]) + houses[i][3];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            answer = Math.min(dy[N][i], answer);
        }

        System.out.println(answer);
    }
}
