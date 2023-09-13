package grind75.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int answer = 0;
        for(int right = 0, left = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
