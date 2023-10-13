package core.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Q15651 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        rec(n, m, new int[m], 0);
        System.out.println(sb);
    }

    public static void rec(int n, int m, int[] answer, int k) {
        if(k == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        } else {
            for(int i = 1; i <= n; i++) {
                answer[k] = i;
                rec(n, m, answer, k + 1);
            }
        }
    }
}
