package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/14 17:42
 * @description:
 */
public class Leecode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] intervalsNew = new int[intervals.length + 1][2];
        int j = 0;
        for (; j < intervals.length; j++) {
            if (intervals[j][0] > newInterval[0]) {
                break;
            }
            intervalsNew[j][0] = intervals[j][0];
            intervalsNew[j][1] = intervals[j][1];
        }
        intervalsNew[j][0] = newInterval[0];
        intervalsNew[j][1] = newInterval[1];
        for (; j < intervals.length; j++) {
            intervalsNew[j + 1][0] = intervals[j][0];
            intervalsNew[j + 1][1] = intervals[j][1];
        }
        intervals = intervalsNew;
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
        Leecode57 leecode57 = new Leecode57();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = leecode57.insert(intervals, newInterval);
        for (int[] i : insert) {
            System.out.print("[" + i[0] + "," + i[1] + "]");
            System.out.print(",");
        }
    }
}
