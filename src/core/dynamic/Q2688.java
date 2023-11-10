package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2688 {

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
            long[][] dy = new long[N + 1][10];
            Arrays.fill(dy[1], 1);
            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = j; k < 10; k++) {
                        dy[i][j] += dy[i - 1][k];
                    }
                }
            }

            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dy[N][i];
            }

            System.out.println(answer);
        }
    }
}
