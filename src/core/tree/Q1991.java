package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader sc = new FastReader();

    static int[][] tress = new int[30][2];

    public static void main(String[] args) {
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            char curCh = sc.next().charAt(0);
            int parent = (int) curCh - 'A';
            for (int j = 0; j < 2; j++) {
                char ch = sc.next().charAt(0);
                if(ch == '.') tress[parent][j] = -1;
                else tress[parent][j] = (int)(ch - 'A');
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int s) {
        if(s == -1) return;
        System.out.print((char)(s + 'A'));
        for (Integer child : tress[s]) {
            preOrder(child);
        }
    }

    public static void inOrder(int s) {
        if(s == -1) return;
        inOrder(tress[s][0]);
        System.out.print((char)(s + 'A'));
        inOrder(tress[s][1]);
    }

    public static void postOrder(int s) {
        if(s == -1) return;
        postOrder(tress[s][0]);
        postOrder(tress[s][1]);
        System.out.print((char)(s + 'A'));
    }
}
