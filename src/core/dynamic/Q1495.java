package core.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1495 {

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
        int N = sc.nextInt(); // 곡의 개수
        int S = sc.nextInt(); // 시작 볼륨
        int M = sc.nextInt(); // 최대 볼륨

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dy = new int[N + 1][M + 1];
        dy[0][S] = 1;

        for (int i = 1; i <= N; i++) {
            boolean error = true;
            for (int j = 0; j <= M; j++) {
                if (dy[i - 1][j] != 0) {
                    if (j + arr[i] <= M) {
                        dy[i][j + arr[i]]++;
                        error = false;
                    }

                    if(j - arr[i] >= 0) {
                        dy[i][j - arr[i]]++;
                        error = false;
                    }

                }
            }
            if(error) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = M; i >= 0; i--) {
            if(dy[N][i] != 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
