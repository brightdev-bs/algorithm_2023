package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2193 {

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
        int N =sc.nextInt();

        long[][] dy = new long[N + 1][2];
        dy[1][1] = 1;
        if(N >= 2)
            dy[2][0] = 1;
        if(N >= 3) {
            dy[3][0] = 1;
            dy[3][1] = 1;
        }

        for (int i = 4; i <= N; i++) {
            dy[i][1] = dy[i - 1][0];
            dy[i][0] = dy[i - 1][1] + dy[i - 1][0];
        }

        System.out.println(dy[N][0] + dy[N][1]);
    }
}
