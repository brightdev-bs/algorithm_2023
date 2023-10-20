package core.bruteforce;

import java.util.Scanner;

public class Q1182 {

    static boolean[] selected;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        selected = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(arr, n, s, 0);
        if(s == 0) answer--;
        System.out.println(answer);
    }

    public static void DFS(int[] arr, int n, int s, int L) {
        if(L == n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    sum += arr[i];
                }
            }
            if(sum == s) answer++;
        } else {
                    selected[L] = true;
                    DFS(arr, n, s, L + 1);
                    selected[L] = false;
                    DFS(arr, n, s, L + 1);
        }
    }
}
