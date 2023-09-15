package grind75.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] peek = list.get(list.size() - 1);
            if(peek[1] >= intervals[i][0]) {
                list.set(list.size() - 1, new int[]{peek[0], Math.max(peek[1], intervals[i][1])});
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
