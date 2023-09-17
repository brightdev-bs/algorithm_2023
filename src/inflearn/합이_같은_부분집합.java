package inflearn;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.Scanner;

public class 합이_같은_부분집합 {

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = Arrays.stream(arr).sum();
        DFS(arr, 0, sum, 0);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void DFS(int[] arr, int L, int sum, int temp) {
        if(L == arr.length) {
            if(sum - temp == temp)
                flag = true;
        }
        else {
            DFS(arr,L + 1, sum, temp + arr[L]);
            DFS(arr, L + 1, sum, temp);
        }
    }
}
