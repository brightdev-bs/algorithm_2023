package baekjoon.array;

import java.util.Arrays;
import java.util.Scanner;

public class Q10431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int[] h = new int[20];
        while(tc-- > 0) {
            int T = sc.nextInt(); // 반 버리기
            for(int i = 0; i < 20; i++) {
                h[i] = sc.nextInt();
            }

            int[] sorted = new int[20];
            int count = 0;
            for(int i = 0; i < 20; i++) {
                boolean exist = false;
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > h[i]) {
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            count++;
                        }
                        sorted[j] = h[i];
                        exist = true;
                        break;
                    }
                }
                if (!exist) sorted[i] = h[i];
            }
            System.out.println(T + " " + count);
        }
    }
}


