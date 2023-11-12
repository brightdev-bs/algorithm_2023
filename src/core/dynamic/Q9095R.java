package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9095R {

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

    static int[] dy = new int[11];

    public static void main(String[] args) {
        pro();
        int TC = sc.nextInt();
        while(TC-- > 0) {
            int N = sc.nextInt();
            System.out.println(dy[N]);
        }
    }

    private static void pro() {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }
    }
}
