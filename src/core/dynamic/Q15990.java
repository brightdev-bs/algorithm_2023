package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15990 {

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

    static long[][] dy = new long[100_001][4];

    public static void main(String[] args) {
        pro();
        int TC = sc.nextInt();
        while(TC-- > 0) {
            int N = sc.nextInt();
            System.out.println((dy[N][1] + dy[N][2] + dy[N][3]) % 1_000_000_009);
        }
    }

    private static void pro() {
        dy[1][1] = 1;
        dy[2][2] = 1;
        dy[3][1] = 1;
        dy[3][2] = 1;
        dy[3][3] = 1;
        for (int i = 4; i <= 100_000; i++) {
            dy[i][1] += (dy[i - 1][2] + dy[i - 1][3]) % 1_000_000_009;
            dy[i][2] += (dy[i - 2][1] + dy[i - 2][3]) % 1_000_000_009;
            dy[i][3] += (dy[i - 3][1] + dy[i - 3][2]) % 1_000_000_009;
        }
    }
}
