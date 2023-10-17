package core.dynamic;

import java.util.Scanner;

public class Q2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            scores[i] = sc.nextInt();
        }

        int answer = 0;
        int[][] dy = new int[n + 1][n + 1];
        int[] come = new int[n + 1];
        if(n == 1) {
            answer = scores[1];
            come[1] = 0;
        }
        else if(n == 2) {
            answer = scores[2] + scores[1];
            come[2] = 0;
        }
        else {
            // 초기값 셋팅
            dy[1][0] = scores[1];
            dy[2][0] = dy[1][0] + scores[2];
            dy[2][1] = scores[2];

            for(int i = 3; i <= n; i++) {
                dy[i][0] = dy[i - 1][1] + scores[i];
                dy[i][1] = Math.max(dy[i - 2][0], dy[i - 2][1]) + scores[i];
                come[i] = dy[i][0] < dy[i][1] ? 1 : 0;
            }
            answer = Math.max(dy[n][0], dy[n][1]);
        }
        System.out.println(answer);

        int step = n;
        while(step >= 0) {
            System.out.print(step + " -> ");
            if(come[step] == 1) step -= 2;
            else if(come[step] == 0) step -= 1;
        }
    }
}
