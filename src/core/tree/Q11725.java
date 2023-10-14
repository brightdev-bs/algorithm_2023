package core.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q11725 {

    static int[] parents;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        parents = new int[n + 1];
        Arrays.fill(parents, -1);
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        /* 입력 완료 */

        parents[1] = 0;
        DFS(1);
        for(int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void DFS(int k) {
        for (Integer num : list.get(k)) {
            if(parents[num] == -1) {
                parents[num] = k;
                DFS(num);
            }
        }
    }
}
