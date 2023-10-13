package core.bruteforce;

import java.util.Scanner;

public class Q15649 {

    // 시간 복잡도 O(n! / (n - m)! ) => 8!

    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static boolean[] visitied;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        answer = new int[m];
        visitied = new boolean[n + 1];

        solution(n, m, 0);
        System.out.println(sb);
    }

    public static void solution(int n, int m, int L) {
        if(L == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = 1; i <= n; i++) {
                if(!visitied[i]) {
                    visitied[i] = true;
                    answer[L] = i;
                    solution(n, m, L + 1);
                    visitied[i] = false;
                }
            }
        }
    }
}
