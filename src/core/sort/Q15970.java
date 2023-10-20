package core.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q15970 {

    static List<List<Integer>> dots = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            dots.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            int color = sc.nextInt();
            dots.get(color).add(pos);
        }

        for(int i = 0; i <= n; i++) {
            Collections.sort(dots.get(i));
        }

        int sum = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < dots.get(i).size(); j++) {
                int left = getLeft(i, j);
                int right = getRight(i, j);
                sum += Math.min(left, right);
            }
        }
        System.out.println(sum);
    }

    private static int getLeft(int color, int index) {
        if(index == 0) return Integer.MAX_VALUE;
        else return dots.get(color).get(index) - dots.get(color).get(index - 1);
    }

    private static int getRight(int color, int index) {
        if(index == dots.get(color).size() - 1) return Integer.MAX_VALUE;
        else return dots.get(color).get(index + 1) - dots.get(color).get(index);
    }
}
