package core.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q1015 {

    static class Pair implements Comparable<Pair> {
        int num, idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.num == o.num) return this.idx - o.idx;
            return this.num - o.num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) {
            int num =sc.nextInt();
            arr[i] = new Pair(num, i);
        }

        Arrays.sort(arr);

        int[] p =  new int[n];
        for(int i = 0; i < n; i++) {
            p[arr[i].idx] = i;
        }

        for (int i : p) {
            System.out.print(i + " ");
        }
    }
}
