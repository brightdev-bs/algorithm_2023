package core.dynamic;

import java.util.Scanner;

public class Q11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dy = new int[1001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 3;
        for(int i = 4; i <= 1000; i++) {
            dy[i] = (dy[i - 2] + dy[i - 1]) % 10007;
        }

        System.out.println(dy[n]);
    }
}
