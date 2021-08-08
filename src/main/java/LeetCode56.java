package main.java;

import java.util.*;

/**
 * @author sakura
 * @date: 2021/3/14 17:13
 * @description:
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] i : intervals) {
            if (result.size() == 0) {
                result.add(i);
                continue;
            }
            int[] ints = result.get(result.size() - 1);
            if (ints[1] >= i[0]) {
                ints[1] = Math.max(i[1], ints[1]);
            } else {
                result.add(i);
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = leetCode56.merge(intervals);
        for (int[] i : merge) {
            System.out.print("[" + i[0] + "," + i[1] + "]");
            System.out.print(",");
        }
    }
}