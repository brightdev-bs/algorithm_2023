package core.binarsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2805 {

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
    }

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        long right = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        long answer = Long.MAX_VALUE;
        long left = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long result = cut(arr, mid);
            if(result == m) {
                answer = mid;
                break;
            } else if(result > m) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    private static long cut(int[] arr, long length) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > length) sum += arr[i] - length;
        }

        return sum;
    }


}
