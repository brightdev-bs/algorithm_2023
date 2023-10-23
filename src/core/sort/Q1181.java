package core.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181 {

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

        String nextLine() {
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return input;
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int N = scan.nextInt();
        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
             words[i] = scan.nextLine();
        }

        Set<String> answer = new HashSet<>();
        for (String word : words) {
            answer.add(word);
        }

        List<String> list = new ArrayList<>();
        for (String word : answer) {
            list.add(word);
        }

        Collections.sort(list, (a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            else return a.length() - b.length();
        });


        for (String s : list) {
            System.out.println(s);
        }
    }
}
