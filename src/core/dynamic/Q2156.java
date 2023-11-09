package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2156 {

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
        int[] wines = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wines[i] = sc.nextInt();
        }

        int[] dy = new int[N + 1];
        dy[1] = wines[1];
        if(N >= 2)
            dy[2] = wines[2] + wines[1];

        for (int i = 3; i <= N; i++) {
            dy[i] = Math.max(dy[i - 3] + wines[i - 1] + wines[i], dy[i - 2] + wines[i]);
            dy[i] = Math.max(dy[i], dy[i - 1]);
        }



        System.out.println(dy[N]);
    }
}
