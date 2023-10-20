package core.binarsearch;

import java.util.Arrays;
import java.util.Scanner;

public class Q7795 {

    static int[] a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int len = sc.nextInt();
            int len2 = sc.nextInt();
            a = new int[len];
            b = new int[len2];
            for(int i = 0; i < len; i++) {
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < len2; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int sum = 0;
            for(int i = 0; i < len; i++) {
                int smallCount = binarySearch(a[i]);
                sum += smallCount + 1;
            }
            System.out.println(sum);
        }
    }

    private static int binarySearch(int target) {
        int l = 0, r = b.length - 1;
        int result = 0;
        while(l <= r) {
            int mid = ( l + r ) / 2;
            if(target <= b[mid]) {
                if(mid == 0) return -1;
                r = mid - 1;
            } else {
                result = mid;
                l = mid + 1;
            }
        }

        return result;
    }
}


