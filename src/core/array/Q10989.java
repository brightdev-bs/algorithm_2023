package core.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10989 {

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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)  {
            arr[i] = sc.nextInt();
        }

        int[] mem = new int[10_001];
        for (int i : arr) {
            mem[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10_001; i++) {
            if(mem[i] != 0) {
                for (int j = 0; j < mem[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
