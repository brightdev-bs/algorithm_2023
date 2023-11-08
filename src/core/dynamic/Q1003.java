package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1003 {

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

    static int[][] dy = new int[41][2];

    public static void main(String[] args) {
        int TC = sc.nextInt();

        pro();

        while(TC-- > 0) {
            int N = sc.nextInt();
            System.out.println(dy[N][0] + " " + dy[N][1]);
        }
    }

    private static void pro() {
        dy[0][0] = 1;
        dy[1][1] = 1;
        for (int i = 2; i<= 40; i++) {
            dy[i][0] = dy[i - 2][0] + dy[i - 1][0];
            dy[i][1] = dy[i - 2][1] + dy[i - 1][1];
        }
    }
}
