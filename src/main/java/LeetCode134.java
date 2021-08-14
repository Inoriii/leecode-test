package main.java;

import main.java.util.StringUtil;

/**
 * @author sakura
 * @date: 2021/8/8 14:11
 * @description:
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || cost.length != gas.length) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < 0) {
                continue;
            }
            int sum = 0;
            boolean isOk = false;
            int j = i % gas.length;
            for (; j < gas.length + i; j++) {
                sum += gas[j % gas.length];
                if (sum < 0) {
                    isOk = false;
                    break;
                }
                isOk = true;
            }
            if (isOk) {
                return i;
            }
            i = Math.max(i, j % gas.length - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode134 leetCode134 = new LeetCode134();
        int i = leetCode134.canCompleteCircuit(
                StringUtil.string2Array1("[3,3,4]"),
                StringUtil.string2Array1("[3,4,4]")
        );
        System.out.println(i);
    }
}
