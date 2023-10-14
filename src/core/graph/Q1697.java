package core.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {

    static boolean[] visitied = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visitied[n] = true;
        int time = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            time++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                if(cur == k) {
                    flag = true;
                    break;
                }
                int a = cur + 1;
                int b = cur - 1;
                int c = cur * 2;
                if(a <= 100000 && !visitied[a]) {
                    queue.add(a);
                    visitied[a] = true;
                }
                if(b >= 0 && !visitied[b]) {
                    queue.add(b);
                    visitied[b] = true;
                }
                if(c <= 100000 && !visitied[c]) {
                    queue.add(c);
                    visitied[c] = true;
                }
            }
            if(flag) break;
        }

        System.out.println(time - 1);
    }
}
