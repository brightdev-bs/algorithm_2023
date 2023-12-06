package core.simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2840 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.nextLine();

        char[] mem = new char[N];
        Arrays.fill(mem, '?');

        int cursor = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int changed = sc.nextInt();
            char alphabet = sc.next().charAt(0);

            cursor = (((cursor - changed) % N) + N) % N;
            if (mem[cursor] == '?') {
                mem[cursor] = alphabet;
                if(set.contains (alphabet)) {
                    System.out.println("!");
                    return;
                }
                set.add(alphabet);
            } else if (mem[cursor] != alphabet) {
                System.out.println("!");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(mem[(cursor + i) % N]);
        }

    }
}
