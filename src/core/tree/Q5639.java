package core.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q5639 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            list.add(a);
        }
        DFS(0, list.size() - 1);
    }

    public static void DFS(int s, int e) {
        if (s > e)  {
            return;
        }


        int mid = s + 1;
        while (mid <= e && list.get(mid) < list.get(s)) {
            mid++;
        }

        DFS(s + 1, mid - 1);
        DFS(mid, e);
        System.out.println(list.get(s));
    }

}
