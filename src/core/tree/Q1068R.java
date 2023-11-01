package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1068R {

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

    static List<List<Integer>> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if(parent == -1) root = i;
            else list.get(parent).add(i);
        }

        int target = sc.nextInt();
        if(target == root) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i <= N; i++) {
            if(list.get(i).contains(target)) list.get(i).remove(list.get(i).indexOf(target));
        }
        DFS(root);
        System.out.println(count);
    }

    public static void DFS(int start) {
        if(list.get(start).size() == 0) count++;
        for (Integer child : list.get(start)) {
            DFS(child);
        }
    }
}
