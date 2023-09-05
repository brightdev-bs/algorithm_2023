package grind75.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                for( ;i < intervals.length; i++) {
                    list.add(intervals[i]);
                }
                return toArray(list);
            }

            else if(intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            }

            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        list.add(newInterval);

        return toArray(list);
    }

    private int[][] toArray(List<int[]> list) {
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
