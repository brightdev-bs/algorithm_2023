package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5557 {

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

    static int N;
    static int[] A;
    static long[][] dy;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        dy = new long[N + 1][21];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }

    private static void pro() {
        dy[1][A[1]] = 1;

        for (int i = 2; i <= N - 1; i++) {
            for (int prev = 0; prev <= 20; prev++) {
                for (int cur : new int[]{prev - A[i], prev + A[i]}) {
                    if(cur < 0 || cur > 20) continue;
                    dy[i][cur] += dy[i - 1][prev];
                }
            }
        }

        System.out.println(dy[N - 1][A[N]]);
    }
}
