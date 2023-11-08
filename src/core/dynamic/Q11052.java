package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 {

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
        int[] prices = new int[N + 1];
        int[] dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int input = sc.nextInt();
            prices[i] = input;
            dy[i] = input;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dy[j] = Math.max(dy[j], dy[j - i] + prices[i]);
            }
        }

        System.out.println(dy[N]);
    }
}
