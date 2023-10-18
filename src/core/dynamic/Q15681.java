package core.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q15681 {

    static int[] dy;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();

        dy = new int[N + 1];
        list = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for(int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(R, -1);

        for(int i = 0; i < Q; i++) {
            System.out.println(dy[sc.nextInt()]);
        }
    }

    public static void DFS(int n, int prev) {
        dy[n] += 1;
        for (int next : list.get(n)) {
            if(next == prev) continue;
            DFS(next, n);
            dy[n] += dy[next];
        }
    }

}
