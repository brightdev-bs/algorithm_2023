package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = ( left + right ) / 2;
            if(arr[mid] == m) {
                System.out.println(mid + 1);
                return;
            }
            if(arr[mid] > m) right = mid - 1;
            else left = mid + 1;
        }
    }
}
