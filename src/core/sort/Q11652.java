package core.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q11652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        int max = 1;
        long ansNum = arr[0];
        int count = 1;
        long prev = arr[0];
        for(int i = 1; i < n; i++) {
            if(prev == arr[i]) {
                count++;
                if(max < count) {
                    max = count;
                    ansNum = arr[i];
                }
            } else {
                count = 1;
                prev = arr[i];
            }
        }

        System.out.println(ansNum);
    }
}
