package core.dynamic;

import java.util.Scanner;

public class Q9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while(tc-- > 0) {
            int n = sc.nextInt();
            int[] dy = new int[12];
            dy[1] = 1;
            dy[2] = 2;
            dy[3] = 4;

            for(int i = 4; i <= n; i++) {
                for(int j = 1; j <= 3; j++) {
                    dy[i] += dy[i - j];
                }
            }
            System.out.println(dy[n]);
        }
    }
}
