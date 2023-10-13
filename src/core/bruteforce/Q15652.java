package core.bruteforce;

import java.util.Scanner;

public class Q15652 {

    // 시간 복잡도 = O(N^M);

    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        answer = new int[m];
        helper(n, m, 0, 1);
        System.out.println(sb);
    }

    public static void helper(int n, int m, int L, int s) {
        if(L == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
         } else {
            for(int i = s; i <= n; i++) {
                answer[L] = i;
                helper(n,m,L + 1, i);
            }
        }
    }
}
