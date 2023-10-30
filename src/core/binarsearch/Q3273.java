package core.binarsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q3273 {

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

    static int[] arr;

    public static void main(String[] args) {
        int n = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int x = sc.nextInt();

        int count = 0;
        for(int i = 0; i < n ; i++) {
            if(binarySearch(i + 1, n - 1, x - arr[i]) == 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int binarySearch(int s, int e, int target) {
        while(s <= e) {
            int mid = ( s + e ) / 2;
            if(arr[mid] == target) {
                return 1;
            }

            if(arr[mid] > target) e = mid - 1;
            else s = mid + 1;
        }

        return -1;
    }

}
