package core.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Q11066 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            int[][] sum = new int[n + 1][n + 1];
            sum[0][0] = arr[0];
            for(int i = 1; i <= n; i++) {
                for(int j = i; j<= n; j++) {
                    sum[i][j] = sum[i][j - 1] + arr[j];
                }
            }

            int[][] dy = new int[n + 1][n + 1];
            for(int len = 2; len <= n; len++) {
                for(int start = 1; start <= n - len + 1; start++) {
                    int end = start + len - 1;
                    dy[start][end] = Integer.MAX_VALUE;

                    for(int k = start; k < end; k++) {
                        dy[start][end] = Math.min(dy[start][end], dy[start][k] + dy[k + 1][end] + sum[start][end]);
                    }
                }
            }

            System.out.println(dy[1][n]);
        }
    }
}
