package baekjoon;

import java.util.Scanner;

public class Q1032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.next();
        }

        int len = inputs[0].length();
        char[] answer = new char[len];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = 0; k  < len; k++) {
                    if (inputs[i].charAt(k) != inputs[j].charAt(k)) {
                        answer[k] = '?';
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (answer[i] != '?') {
                answer[i] = inputs[0].charAt(i);
            }
        }

        System.out.println(answer);
    }
}
