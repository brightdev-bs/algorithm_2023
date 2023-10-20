package core.binarsearch;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2470 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr, 1, n + 1);
        int answer = Integer.MAX_VALUE;
        int[] ele = new int[2];
        for(int left = 1; left <= n; left++) {
            int res = binarySearch(left + 1, n, -arr[left]);
            if (left < res - 1 && answer > Math.abs(arr[res - 1] + arr[left])) {
                answer = Math.abs(arr[res - 1] + arr[left]);
                ele = new int[]{arr[left], arr[res - 1]};
            }

            if(res <= n && answer > Math.abs(arr[res] + arr[left])) {
                answer = Math.abs(arr[res] + arr[left]);
                ele = new int[]{arr[left], arr[res]};
            }
        }

        Arrays.sort(ele);
        System.out.println(ele[0] + " " + ele[1]);
    }


    private static int binarySearch(int L, int R, int target) {
        int result = R + 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] >= target) {
                R = mid - 1;
                result = mid;
            }
            else {
                L = mid + 1;
            }
        }

        return result;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
