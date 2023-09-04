package grind75.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,8};
        Map<Integer, Integer> map = Arrays.stream(nums).mapToObj(n -> n)
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)));

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
            if(max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
