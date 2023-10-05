package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {

    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 2;
        hanoi(n, 1, 2, 3);
        for (int[] ints : list) {
            System.out.println(ints[0] + "," + ints[1]);

        }
    }

    public static void hanoi(int n, int from, int via, int to) {
        if(n == 0) return;
        hanoi(n - 1, from, to, via);
        list.add(new int[]{from, to});
        hanoi(n - 1, via, from, to);
    }


}
