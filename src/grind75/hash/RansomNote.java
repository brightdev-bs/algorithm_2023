package grind75.hash;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Integer> map = new HashMap<>();
        ransomNote.chars().forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
        magazine.chars().forEach(c -> map.put(c, map.getOrDefault(c, 0) - 1));
        for (Integer value : map.values()) {
            if(value > 0) return false;
        }



        return true;
    }

    public static void main(String[] args) {

    }
}
