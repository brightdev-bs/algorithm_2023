package core.binarsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {

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
    static int N, C;
    static long[] houses;

    public static void main(String[] args) {

        input();

        Arrays.sort(houses);

        // solve
        long left = 1;
        long right = houses[N - 1];
        long answer = 0;
        while(left <= right) {
            long mid = (left + right ) / 2;
            if(canUseAll(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static void input() {
        N = sc.nextInt();
        C = sc.nextInt();

        houses = new long[N];
        for(int i = 0; i < N; i++) {
            houses[i] = sc.nextLong();
        }
    }

    private static boolean canUseAll(long len) {
        int count = 1;
        long prev = houses[0];
        for(int i = 1; i < N; i++) {
            if(houses[i] - prev >= len) {
                count++;
                prev = houses[i];

                if(count == C) return true;
            }
        }
        return false;
    }
}
