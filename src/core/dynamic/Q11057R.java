package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11057R {

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

    static int[][] dp;

    public static void main(String[] args) {
        int N = sc.nextInt();
        dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);

        for (int n = 2; n <= N; n++) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[n][i] += dp[n - 1][j];
                    dp[n][i] %= 10_007;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % 10_007);

    }
}
