package baekjoon.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }

        char answer = ' ';
        for (Character c : map.keySet()) {
            if(map.get(c) == max) {
                if(answer == ' ') answer = c;
                else if(answer != ' ') answer = '?';
            }
        }

        System.out.println(Character.toUpperCase(answer));
    }
}
