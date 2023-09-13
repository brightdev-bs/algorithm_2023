package grind75.hash;

import java.util.*;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (int) ((Math.pow(a[0], 2) + Math.pow(a[1], 2)) - (Math.pow(b[0], 2) + Math.pow(b[1], 2)));
        });

        for(int[] point : points) {
            queue.add(point);
        }

        int[][] answer = new int[k][];
        for(int i = 0; i < k; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[][] answer = kClosest(new int[][]{
//                {3, 3},
//                {5, -1},
//                {-2, 4}
//        }, 2);

        int[][] answer = kClosest(
                new int[][]{
                        {1, 3},
                        {-2, 2}
                },
                1
        );

        for (int[] ints : answer) {
            System.out.println(ints[0] + " : " + ints[1]);
        }
    }
}
