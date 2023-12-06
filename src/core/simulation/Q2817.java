package core.simulation;

import java.util.*;

public class Q2817 {

    static class Staff {
        char c;
        int voted;

        public Staff(char c, int voted) {
            this.c = c;
            this.voted = voted;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int N = sc.nextInt();
        List<Staff> candidates = new ArrayList<>();
        double bar = X * 0.05;
        for (int i = 0; i < N; i++) {
            char name = sc.next().charAt(0);
            int voted = sc.nextInt();
            if (voted > bar)
                candidates.add(new Staff(name, voted));
        }

        candidates.sort((a, b) -> a.c - b.c);

        // 2. 14개 계싼하기
        List<Staff> result = new ArrayList<>();
        for (Staff candidate : candidates) {
            for (int i = 1; i <= 14; i++) {
                result.add(new Staff(candidate.c, candidate.voted / i));
            }
        }

        Collections.sort(result, (a, b) -> b.voted - a.voted);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 14; i++) {
            char name = result.get(i).c;
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (Staff candidate : candidates) {
            int value = map.getOrDefault(candidate.c, 0);
            System.out.println(candidate.c + " " + value);
        }
    }
}
