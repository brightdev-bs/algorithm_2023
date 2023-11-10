package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1309 {

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
        int[][] dy = new int[N][3];
        dy[0][0] = 1;
        dy[0][1] = 1;
        dy[0][2] = 1;
        for (int i = 1; i < N; i++) {
            dy[i][0] = (dy[i - 1][1] + dy[i - 1][2]) % 9901;
            dy[i][1] = (dy[i - 1][0] + dy[i - 1][2]) % 9901;
            dy[i][2] = (dy[i - 1][0] + dy[i - 1][1] + dy[i - 1][2]) % 9901;
        }

        System.out.println((dy[N - 1][0] + dy[N - 1][1] + dy[N - 1][2]) % 9901);
    }
}
