package grind75.review;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (int) ((Math.pow(a[0], 2) + Math.pow(a[1], 2)) - (Math.pow(b[0], 2) + Math.pow(b[1], 2)));
        });

        for(int[] point : points) {
            pq.add(point);
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(pq.poll());
        }

        int[][] answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
