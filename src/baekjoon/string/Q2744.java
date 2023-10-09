package baekjoon.string;

import java.util.Scanner;

public class Q2744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }

        System.out.println(sb);

    }
}
