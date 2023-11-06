package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀기
public class Q11066R {

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

    static int[][] sum;

    public static void main(String[] args) {
        int TC = sc.nextInt();
        while(TC-- > 0) {
            int K = sc.nextInt();
            int[] files = new int[K + 1];
            sum = new int[K + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                files[i] = sc.nextInt();
            }

            pro(files, K);

            int[][] solve = solve(files, K);
            System.out.println(solve[1][K]);
        }
    }

    private static void pro(int[] files, int K) {
        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j - 1] + files[j];
            }
        }
    }

    private static int[][] solve(int[] files, int K) {
        int[][] dp = new int[K + 1][K + 1];
        for (int len = 2; len <= K; len++) {
            for (int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k + 1][j] + sum[i][j]
                    );
                }
            }
        }

        return dp;
    }
}
