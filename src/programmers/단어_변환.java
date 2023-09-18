package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    class Solution {

        public int solution(String begin, String target, String[] words) {
            boolean flag = false;
            for(String word : words) {
                if(word.equals(target)) flag = true;
            }

            if(!flag) return 0;

            Queue<String> queue = new LinkedList<>();
            queue.add(begin);
            int dept = 0;
            while(!queue.isEmpty()) {
                dept++;
                int len = queue.size();
                for(int i = 0; i < len; i++) {
                    String curString = queue.poll();
                    if(curString.equals(target)) return dept - 1;
                    for(String word : words) {
                        if(diffCount(curString ,word) == 1) queue.add(word);
                    }
                }
            }

            return 0;
        }

        public int diffCount(String a, String b) {
            int count = 0;
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) count++;
            }

            return count;
        }
    }
}
