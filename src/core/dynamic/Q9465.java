package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {

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
        int TC = sc.nextInt();
        while(TC-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[3][N + 1];
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // row col
            int[][] dy = new int[3][N + 1];
            dy[1][1] = arr[1][1];
            dy[2][1] = arr[2][1];

            for (int i = 2; i <= N; i++) {
                dy[1][i] = Math.max(dy[2][i - 1], dy[2][i - 2]) + arr[1][i];
                dy[2][i] = Math.max(dy[1][i - 1], dy[1][i - 2]) + arr[2][i];
            }

//            for (int i = 1; i <= 2; i++) {
//                for (int j = 1; j <= N; j++) {
//                    System.out.print(dy[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(Math.max(dy[1][N], dy[2][N]));
        }
    }
}
