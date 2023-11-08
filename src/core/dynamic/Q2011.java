package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2011 {

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

        String nextLine() {
            String s;
            try {
                s = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return s;
        }
    }

    static FastReader sc = new FastReader();

    static int[] dy;


    public static void main(String[] args) {
        String s = sc.nextLine();
        int N = s.length();
        dy = new int[N];

        if (s.charAt(0) != '0') dy[0] = 1;

        for (int i =1; i< N; i++) {

            if (s.charAt(i) != '0') dy[i] = dy[i - 1];

            if (check(s.charAt(i - 1), s.charAt(i))) {
                if(i >= 2 ) dy[i] += dy[i - 2];
                else dy[i] += 1;
                dy[i] %= 1000000;
            }
        }
        System.out.println(dy[N - 1]);
    }

    static boolean check(char A, char B) {
        if(A == '0') return false;
        if(A == '1') return true;
        if(A >= '3') return false;
        return B <= '6';
    }


}
