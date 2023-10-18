package core.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1949 {

    static List<List<Integer>> list;
    static int[][] dy = new int[10005][2];
    static int[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        nodes = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            nodes[i] = sc.nextInt();
        }

        list = IntStream.rangeClosed(0, N)
                .mapToObj(m -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for(int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(1, -1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    public static void DFS(int n, int prev) {
        dy[n][0] = 0;
        dy[n][1] = nodes[n];
        for (Integer next : list.get(n)) {
            if(next == prev) continue;
            DFS(next, n);
            dy[n][0] += Math.max(dy[next][0], dy[next][1]);
            dy[n][1] += dy[next][0];
        }
    }
}
