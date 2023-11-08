package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15991 {

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

    static long[] dy = new long[100_001];

    public static void main(String[] args) {
        int TC = sc.nextInt();
        pro();
        while(TC-- > 0) {
            int N = sc.nextInt();
            System.out.println(dy[N]);
        }

    }

    private static void pro() {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 2;
        dy[4] = 3;
        dy[5] = 3;
        dy[6] = 6;
        for (int i = 7; i <= 100_000; i++) {
            dy[i] = (dy[i - 2] + dy[i - 4] + dy[i - 6]) % 1_000_000_009;
        }
    }
}
