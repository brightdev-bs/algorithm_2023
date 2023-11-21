package core.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10448 {

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
        int TC = sc.nextInt();
        int[] arr = new int[51];

        for (int i = 0; i <= 50; i++) {
            arr[i] = (i * (i + 1)) / 2;
        }

        while(TC-- > 0) {
            int K = sc.nextInt();
            boolean flag = false;
            for (int i = 1; i < 50; i++) {
                for (int j = 1; j < 50; j++) {
                    for (int k = 1; k < 50; k++) {
                        if(arr[i] + arr[j] + arr[k] == K){
                            flag = true;
                        }
                    }
                    if(flag) break;
                }
                if(flag) break;
            }
            if(flag) System.out.println(1);
            else System.out.println(0);
        }


    }
}
