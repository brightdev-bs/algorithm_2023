package baekjoon.string;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1919 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s1 = sc.next();
            String s2 = sc.next();

            Map<Character, Integer> map = new HashMap<>();

            s1.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));

            s2.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> map.put(c, map.getOrDefault(c, 0) - 1));

            int answer = map.values()
                    .stream()
                    .mapToInt(Math::abs)
                    .sum();

            System.out.println(answer);
        }
    }
}
