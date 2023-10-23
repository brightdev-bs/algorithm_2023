package core.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1795 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    static FastReader scan = new FastReader();
    static int L, C;
    static char[] alphabets, answer;
    static boolean[] used = new boolean[26];
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        input();

        Arrays.sort(alphabets);

        select(0, 0);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void input() {
        L = scan.nextInt();
        C = scan.nextInt();

        answer = new char[L];
        alphabets = new char[C];
        for(int i = 0; i < C; i++) {
            alphabets[i] = scan.next().charAt(0);
        }
    }

    private static void select(int level, int start) {
        if(level == L) {
            int vowelCnt = 0;
            for(int i = 0; i < L; i++) {
                if (vowels.contains(answer[i])) vowelCnt++;
            }

            if(vowelCnt >= 1 && L - vowelCnt >= 2) result.add(String.valueOf(answer));
        } else {
            for(int i = start; i < C; i++) {
                char cur = alphabets[i];
                answer[level] = cur;
                select(level + 1, i + 1);
            }
        }
    }


}