package core.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Q11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dy = new int[n + 1][10];
        Arrays.fill(dy[1], 1);


        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dy[i][j] += dy[i - 1][k];
                    dy[i][j] %= 10007;
                }
            }
        }

        int answer = 0;
        for(int j = 0; j <= 9; j++) {
            answer += dy[n][j];
            answer %= 10007;
        }

        System.out.println(answer);
    }
}
