package core.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q15663 {

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
    static int N, M;
    static int[] arr;
    static int[] temp;
    static boolean[] visited = new boolean[100001];
    static Set<List<Integer>> answer = new LinkedHashSet<>();


    public static void main(String[] args) {
        input();

        Arrays.sort(arr);
        select(0);

        for (List<Integer> list : answer) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        temp = new int[M];
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    private static void select(int L) {
        if(L == M) {
            List<Integer> l = new ArrayList<>();
            for (int i : temp) {
                l.add(i);
            }
            answer.add(l);
        } else {
            for(int i = 0; i < N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[L] = arr[i];
                    select(L + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
