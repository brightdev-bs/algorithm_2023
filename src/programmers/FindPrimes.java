package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPrimes {
    public int solution(String numbers) {
        Set<String> comSet = new HashSet<>();
        Set<Integer> primes = new HashSet<>();
        getPrimes(primes, new int[1000001]);
        makeCombination(comSet, "", numbers, new boolean[numbers.length()]);

        int answer = 0;
        for(String s : comSet) {
            if(!s.startsWith("0") && primes.contains(Integer.parseInt(s))) answer++;
        }
        return answer;
    }

    private void makeCombination(Set<String> comSet, String comb, String numbers, boolean[] visited) {
        if(!comb.equals("")) comSet.add(comb);
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                makeCombination(comSet, comb + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    private void getPrimes(Set<Integer> set, int[] ch) {
        for(int i = 2; i < 1000001; i++) {
            if(ch[i] == 0) {
                set.add(i);
                for(int j = i; j < 1000001; j += i) {
                    ch[j]++;
                }
            }
        }
    }
}
