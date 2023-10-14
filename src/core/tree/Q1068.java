package core.tree;


import java.util.*;

public class Q1068 {

    static List<List<Integer>> list = new ArrayList<>();
    static int[] leaf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        leaf = new int[n];

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        int root = -1;
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(input == -1) root = i;
            else list.get(input).add(i);
        }

        int k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            if(list.get(i).contains(k)) list.get(i).remove(list.get(i).indexOf(k));
        }
        if(root != k) DFS(root);

        System.out.println(leaf[root]);
    }

    private static void DFS(int root) {
        if(list.get(root).isEmpty()) leaf[root] = 1;
        for(int next : list.get(root)) {
            DFS(next);
            leaf[root] += leaf[next];
        }
    }
}

