package grind75.hash;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(v -> 1)));

        int answer = 0;
        boolean oneExists = false;
        for(Integer value : map.values()) {
            if(value % 2 == 1) oneExists = true;
            if(value >= 2) {
                answer += (value / 2) * 2;
            }
        }

        if(oneExists) return answer + 1;
        else return answer;
    }

    public int longestPalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        int answer = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                answer += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if(!set.isEmpty()) answer++;

        return answer;

    }
}
