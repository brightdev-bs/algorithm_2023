package core.binarsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {

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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static FastReader sc = new FastReader();


    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < M; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 2) {
                list.add(key);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
